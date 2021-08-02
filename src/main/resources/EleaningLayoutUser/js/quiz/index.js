let urlParam = new URLSearchParams(window.location.search);
let id = urlParam.get("id");
function loadQuestion() {
  axios({
    url: `http://localhost:8082/api/user/question/${id}`,
    method: "get",
  })
    .then(function (resp) {
      let listQuestion = resp.data;
      document.getElementById("numberQuestion").value= listQuestion.length;
      // console.log(listQuestion.length);
      let content = "";
      let No = 1;
      for (let question of listQuestion) {
        let contentAnswer = "";
        for (let answer of question.listAns) {
          contentAnswer += `
      <li class="content-item">
      <input type="radio" id="answer${No}" value="${answer.is_right}"/>
      <span>
      ${answer.ans_content}
      </span>
      </li>
          `;
        }
        content +=
          ` 
    <div class="content">
    <h5 class="question-number">${No}.</h5>
    <p class="question-content">
    ${question.question_content}
    </p>
   
</div>
<ul class="content-list">
` +
          contentAnswer +
          `
</ul>

        `;
        No++;
      }
      document.getElementById("question-list").innerHTML = content;
    })
    .catch(function (err) {
      console.log(err);
    });
}
loadQuestion();



function submitQuestion(){

  let a = document.getElementById("numberQuestion").value;
  alert(a);
  

}
submitQuestion();