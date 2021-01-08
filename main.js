let board = [];

let reloadBoard = [];

$(() => {
  start();
  autoSolveEvent();
  reloadEvent();
  chooseLevelEvent();
});

function start() {
  $("#modal-level").modal("show");
  $("#btn-start").on("click", function () {
    let val = parseInt($("#input-level").val());
    if (val < 3) val = 3;
    if (val > 12) val = 12;
    init(val);
    $("#modal-level").modal("hide");
  });
}

function init(level) {
  board = [];
  for (let i = 0; i < level; i++) {
    board.push(new Array(level).fill(0, 0));
  }
  board = randomSudoku(board, level);
  reloadBoard = board.map((row) => row.slice());
  print(board);
}

function print(boardx) {
  let template = "";

  boardx.forEach((row, iRow) => {
    template = template.concat(
      `<tr>${row
        .map(
          (cell, iCol) => `<td>
        <input ${cell != 0 ? "disabled" : ""}
             row='${iRow}' col='${iCol}'
             type='number' value='${cell > 0 ? cell : ""}'/>
        </td>`
        )
        .join("")}</tr>`
    );

    $("#board").html(template);
  });
  cellEvent();
}

function autoSolveEvent() {
  $("#btn-solve").on("click", function () {
    board = solveSudoku(board);
    print(board);
  });
}

function reloadEvent() {
  $("#btn-reload").on("click", function () {
    board = reloadBoard.map((row) => row.slice());
    print(board);
  });
}

function chooseLevelEvent() {
  $("#btn-level").on("click", function () {
    start();
  });
}

function cellEvent() {
  $("td")
    .find("input")
    .on("change", function () {
      let thiz = $(this);
      //change value
      if (thiz.val() > 0 && thiz.val() <= board[0].length) {
        //check correct
        let row = thiz.attr("row");
        let col = thiz.attr("col");
        let val = parseInt(thiz.val());
        let nums = availableNums(
          board[row],
          getCol(board, col),
          getSquare(board, row, col)
        );
        if (nums.includes(val)) board[row][col] = val;
        else thiz.val("");
      } else thiz.val("");

      //check full board
      if (!board.flat().includes(0)) {
        let rs = checkBoard();
        if (rs) alert("You win");
        else console.log("wrong");
      }
    });
}

function checkBoard() {
  //check rows
  for (const row of board) {
    if (!checkNums(row)) return false;
  }

  //check col
  for (let i; i < board.length; i++) {
    let cols = [];
    for (let j = 0; j < board.length; j++) {
      cols.push(board[j][i]);
    }
    if (!checkNums(cols)) return false;
  }
  //ok
  return true;
}

function checkNums(arr) {
  let sett = new Set(arr);
  sett.delete(0);
  return sett.size === board.length;
}

function solveSudoku(boardx) {
  //count
  let count = 0;
  let goBack = false;
  //solve
  let isDone = false;
  solve(boardx, 0, 0);
  console.log(count);
  return boardx;
  //recourse func
  function solve(boardd, row, col) {
    count++;
    if (isDone) return;
    let tempBoard = boardd.map((r) => [...r]);
    // find next cell
    let nextCol = col + 1;
    let nextRow = row;
    if (col == boardx.length - 1) {
      nextCol = 0;
      nextRow++;
    }
    // check done
    if (!tempBoard.flat().includes(0) || row == boardx.length) {
      console.log("done");
      //logBoard(tempBoard);
      boardx = tempBoard;
      isDone = true;
      return;
    }
    // check empty
    if (tempBoard[row][col] != 0) {
      solve(tempBoard, nextRow, nextCol);
      return;
    }
    //logBoard(boardd);

    // find available nums
    let nums = availableNums(
      tempBoard[row],
      getCol(tempBoard, col),
      getSquare(tempBoard, row, col)
    );
    //console.log(nums);
    // recourse
    if (nums.length === 0) {
      //console.log("go back");
      goBack = true;
      return;
    }

    for (const num of nums) {
      tempBoard[row][col] = num;
      //update view
      //$(`input[row='${row}'][col='${col}']`).val(num);
      //
      solve(tempBoard, nextRow, nextCol);
    }
  }
}

//init random board
function randomSudoku(boardx, level) {
  //solve
  let isDone = false;
  solve(boardx, 0, 0);
  //hide some cell
  let hints = Math.floor(((level ** 2) * 2) / 3);
  while (hints > 0) {
    let row = getRandomInt(0, level - 1);
    let col = getRandomInt(0, level - 1);

    if (boardx[row][col] == 0) continue;

    boardx[row][col] = 0;
    hints--;
  }
  return boardx;
  //recourse func
  function solve(boardd, row, col) {
    if (isDone) return;
    let tempBoard = boardd.map((r) => [...r]);
    // find next cell
    let nextCol = col + 1;
    let nextRow = row;
    if (col == boardx.length - 1) {
      nextCol = 0;
      nextRow++;
    }
    // check done
    if (!tempBoard.flat().includes(0) || row == boardx.length) {
      console.log("done");
      boardx = tempBoard;
      isDone = true;
      return;
    }

    // find available nums
    let nums = availableNums(
      tempBoard[row],
      getCol(tempBoard, col),
      getSquare(tempBoard, row, col)
    );
    // recourse
    if (nums.length === 0) {
      return;
    }
    //nums.sort((a, b) => getRandomInt(0, 2) - 1);
    for (const num of nums) {
      tempBoard[row][col] = num;
      solve(tempBoard, nextRow, nextCol);
    }
  }
}

//util function
function getCol(bo, index) {
  let rs = [];
  for (let i = 0; i < bo.length; i++) {
    rs.push(bo[i][index]);
  }
  return rs;
}

function getSquare(bo, row, col) {
  let rs = [];
  if (bo.length != 9) return [];
  let startRow = Math.floor(row / 3) * 3;
  let startCol = Math.floor(col / 3) * 3;

  for (let i = startRow; i < startRow + 3; i++) {
    for (let j = startCol; j < startCol + 3; j++) {
      rs.push(bo[i][j]);
    }
  }
  return rs;
}

function availableNums(...arrs) {
  let totalSet = new Set(arrs.flat());
  totalSet.delete(0);
  let arr = [];
  for (let i = 1; i <= board.length; i++) {
    if (!totalSet.has(i)) arr.push(i);
  }
  return arr;
}

function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1)) + min;
}
