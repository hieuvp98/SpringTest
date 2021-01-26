$(() => {
  chooseSelection(getScript("1"));
});

function chooseSelection(selection) {
  $(".title h5").html(selection.title);
  $(".content").html(selection.content);
  $(".selections").html("");
  selection.selections.forEach((s, index) => {
    let selec = $("#selection-sample").clone();
    let script = getScript(s);
    selec.find(".selection-content").html(script.title);
    $(".selections").append(selec.html());
    $($(".selections a")[index]).off('click').on("click", function () {
      chooseSelection(script);
    });
  });
}
