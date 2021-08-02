
let urlParam = new URLSearchParams(window.location.search)
let id = urlParam.get('id');

function loadCourse() {
    axios({
        url: `http://localhost:8082/api/admin/course/${id}`,
        method: 'get',
    })
        .then(function (resp) {
            let strOption = `<option value="${resp.data.course_id}">${resp.data.title}</option>`;
            document.getElementById('courseCategory').innerHTML = strOption;
        })
        .catch(function (err) {
            console.log(err)
        })
}
loadCourse();

function addQuestion() {
  let title = document.getElementById("title").value;
  let courseId = document.getElementById("courseCategory").value;
  let correctAnswer= document.getElementById("correctAnswer").value;
    let answerContent1 = document.getElementById('answer1').value;
    let answerContent2 = document.getElementById('answer2').value;
    let answerContent3 = document.getElementById('answer3').value;
    let answerContent4 = document.getElementById('answer4').value;
  
    let question =
    {
        "course_id":courseId,
        "listAns": [
            {
                "ans_content": answerContent1,
                "is_right": correctAnswer == 1 ? true : false ,
            },
            {
                "ans_content": answerContent2,
                "is_right": correctAnswer == 2 ? true : false ,
            },
            {
                "ans_content": answerContent3,
                "is_right": correctAnswer == 3 ? true : false ,
            },
            {
                "ans_content": answerContent4,
                "is_right": correctAnswer == 4 ? true : false ,
            }
        ],
        "question_content": title,
      }

  axios({
    url : 'http://localhost:8082/api/admin/question',
    method:'POST',
    data: question
    
  })
  .then( function (res){
    swal("Successfully !", "You clicked the button!", "success").then(function (res){
        window.location.href = "../ElearningLayoutAdmin/question-index.html?id="+courseId
    });
  })

.catch(function (err) {
    console.log(err.response);
    swal("Unsuccessfully !", "You clicked the button!", "error");
})
}

function Cancel(){
    let courseId = document.getElementById("courseCategory").value;
    window.location.href = "../ElearningLayoutAdmin/question-index.html?id="+ courseId;
}





