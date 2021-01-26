$(() => {
  chooseSelection(script);
});

function chooseSelection(selection) {
  $(".title h5").html(selection.title);
  $(".content").html(selection.content);
  $(".selections").html("");
  selection.selections.forEach((s, index) => {
    let selec = $("#selection-sample").clone();
    selec.find(".selection-content").html(s.title);
    $(".selections").append(selec.html());
    $($(".selections a")[index]).off('click').on("click", function () {
      chooseSelection(s);
    });
  });
}
