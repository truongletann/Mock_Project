
// lay param tren thanh url 
 let urlParam = new URLSearchParams(window.location.search);
 let id  = urlParam.get('id');

function loadAnswer() {
  axios({
    url: `http://localhost:8082/api/admin/question/${id}`,
    method: "GET"
  })
    .then(function(res) {
      document.getElementById("title").value = res.data.question_content;
      document.getElementById("course").value = res.data.course_id;
      
      let check = '';
       
      let test = 1;
      for (let answer of res.data.listAns){
        if(answer.is_right == true){
            check = test;
        }

       document.getElementById("answer" + test).value = answer.ans_content;
       document.getElementById("answerID" + test).value = answer.ans_id;

       test++; 
       console.log(answer.ans_content);
       console.log(check);
    }
    document.getElementById('correctAnswer').options[check - 1].selected = 'selected';  
    })
    .catch((err) => {
      console.log(err);
      swal("Unsuccessfull !", "You clicked the button!", "error");
    });
}

loadAnswer();

function EditQuestion() {
  let title = document.getElementById("title").value;
  let courseId = document.getElementById("course").value;
  let correctAnswer = document.getElementById("correctAnswer").value;
  
  let answerID1  = document.getElementById("answerID1").value;
  let answerID2  = document.getElementById("answerID2").value;
  let answerID3  = document.getElementById("answerID3").value;
  let answerID4  = document.getElementById("answerID4").value;


  let answerContent1 = document.getElementById("answer1").value;
  let answerContent2 = document.getElementById("answer2").value;
  let answerContent3 = document.getElementById("answer3").value;
  let answerContent4 = document.getElementById("answer4").value;
    
  let question = {
    question_id: id,
    course_id: courseId,
    listAns: [
      {
        ans_content: answerContent1,
        is_right: correctAnswer == 1 ? true : false,
        ans_id: answerID1,
        question_id :id 
      },
      {
        ans_content: answerContent2,
        is_right: correctAnswer == 2 ? true : false,
        ans_id: answerID2,
        question_id :id 
      },
      {
        ans_content: answerContent3,
        is_right: correctAnswer == 3 ? true : false,
        ans_id: answerID3,
        question_id :id 
      },
      {
        ans_id: answerID4,
        ans_content: answerContent4,
        is_right: correctAnswer == 4 ? true : false,
        question_id :id 
      },
    ],
    question_content: title,
  };

  axios({
    url: "http://localhost:8082/api/admin/question",
    method: "PUT",
    data: question,
  })
    .then((res) => {
      swal("Successful !", "You clicked the button!", "success").then(res =>{
        window.location.href = "../ElearningLayoutAdmin/question-index.html?id="+courseId
    })
       })
    .catch((err) => {
      console.log(err);
      swal("Unsuccessful !", "You clicked the button!", "error");
    });
}

function Cancel(){
  let courseId = document.getElementById("course").value;
  window.location.href = "../ElearningLayoutAdmin/question-index.html?id="+ courseId;
}