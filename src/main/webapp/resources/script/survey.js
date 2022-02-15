var surveyCount = 0;

function insertSurvey() {
    (++surveyCount >= 10) return;
    let select = document.getElementById("selectType");
    console.log(select.value);

    let question = documen.getElementById("question");

    var input = document.createElement('input');
    input.setAttribute('type', 'text');

}