let urlParam = new URLSearchParams(window.location.search);
let id = urlParam.get("id");

function loadQuestion() {
    axios({
        url: `http://localhost:8082/api/user/question/${id}`,
        method: "get",
    })
        .then(function (resp) {
            let listQuestion = resp.data;
            //so luong cau hoi --> chay for
            document.getElementById("numberQuestion").value = listQuestion.length;
            // console.log(listQuestion.length);
            let content = "";
            let No = 1;
            for (let question of listQuestion) {
                let contentAnswer = "";
                for (let answer of question.listAns) {
                    contentAnswer += `
      <li class="content-item">
<!--      radio cua  cau hoi  -->
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
     <input  type="hidden" id="question${No}" value="${question.question_id}">
     
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

function loadCourse() {
    axios({
        url: `http://localhost:8082/api/admin/course/${id}`,
        method: "get",
    })
        .then(function (resp) {
            document.getElementById('name-course').innerHTML = `<div class="quiz-msg">
                            <h1 style="color: white" >${resp.data.title}</h1>
                        </div>
                        
                           <input type="hidden" name="timeDo" value="${resp.data.time_do}" id="timeDo"> 
                            <p id="timer"><script>countDown();</script></p>
                        <h3 class="text-title" style="color: white" id="count">${resp.data.time_do}</h3>`;

        })
        .catch(function (err) {
            console.log(err);
        });
}

loadCourse();

function loadTitleQuiz() {
    axios({
        url: `http://localhost:8082/api/admin/course/${id}`,
        method: "get",
    })
        .then(function (resp) {
            document.getElementById('title').innerHTML = `
               
                            <h1 style="font-size: 4rem">${resp.data.title}  </h1>
                               <h2 style="font-size: 3rem; color: white" class="text-title">Quiz ${resp.data.time_do} min</h2>
                `;
        })
        .catch(function (err) {
            console.log(err);
        });
}

loadTitleQuiz();

function loadExam() {
    axios({
        url: ` http://localhost:8082/api/user/exam/check/1/${id}`,
        method: "get",
    })
        .then(function (resp) {
            let listExam = resp.data;
            let content = ``;
            for (let exam of listExam) {
                content += `
                <tr class="title-body">
                      <th scope="row">Final Quiz</th>
                            <td>${exam.grade}</td>
                            <td style="color: #17a2b8; font-weight: 400;"> <a href="#">View Feedback</a></td>
                            <td>${exam.grade}</td>
                            <td>${exam.time_need}</td>
                 </tr>           
                    `;
            }
            document.getElementById('list-exam').innerHTML = content;
        })
        .catch(err => {
            console.log(err);
        });
}
loadExam();

function QuizShow(){
     window.location.href ="../EleaningLayoutUser/quiz-show.html?id="+id;
}

function submitQuestion() {
    let numberQuestion = document.getElementById("numberQuestion").value;
    //   vong for theo number question

    console.log(numberQuestion);
    let exampleDetail = {
            "course_id": id,
            "examDetailDTO": [
            {
                "question_id": 1,
                "status_ans": true
            },
            {
                "question_id": 3,
                "status_ans": true
            },
            {
                "question_id": 2,
                "status_ans":true
            }
            ,   {
                    "question_id": 1,
                    "status_ans":false
                }
        ],
            // (10/tong cau hoi ) * so cau dung
            "grade": (numberQuestion/10)*3,
            "number_quiz": 4,
            "time_need": 2345,
            "user_id": 1
    }
    axios({
        url: `http://localhost:8082/api/user/exam`,
        method: "POST",
        data: exampleDetail
    })
        .then( res =>{
            swal("Submit Quiz Success!", "You clicked the button!", "success").then(function (res){
                window.location.href = "../EleaningLayoutUser/quiz.html?id="+id;
            });
        })
        .catch(err=>{
            console.log(err.response);
            swal("Submit Quiz Error !", "You clicked the button!", "error");
    })



}

// submitQuestion();





