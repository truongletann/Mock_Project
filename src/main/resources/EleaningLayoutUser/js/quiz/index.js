let urlParam = new URLSearchParams(window.location.search);
let id = urlParam.get("id");
let token = localStorage.getItem('USER_TOKEN');
function loadQuestion() {
    axios({
        url: `http://localhost:8082/api/user/question/${id}`,
        method: "get",
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
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
      <input type="radio" name="answer${No}" value="${answer.is_right}"/>
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
            // let data = err.response.data;
            // if(data.status == 401){
            //     document.location.href = "../EleaningLayout/index.html";
            // }
            // else if(data.status == 403){
            //     if(token != null){
            //         // XÓA TOKEN KHỎI LOCALSTORAGE
            //         localStorage.removeItem('USER_TOKEN');
            //         document.location.href = "../EleaningLayout/index.html";
            //     }
            // }
        });
}

loadQuestion();

function loadCourse() {
    axios({
        url: `http://localhost:8082/api/admin/course/${id}`,
        method: "get",
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
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
            // let data = err.response.data;
            // if(data.status == 401){
            //     document.location.href = "../EleaningLayout/index.html";
            // }
            // else if(data.status == 403){
            //     if(token != null){
            //         // XÓA TOKEN KHỎI LOCALSTORAGE
            //         localStorage.removeItem('USER_TOKEN');
            //         document.location.href = "../EleaningLayout/index.html";
            //     }
            // }
        });
}

loadCourse();

function loadTitleQuiz() {
    axios({
        url: `http://localhost:8082/api/admin/course/${id}`,
        method: "get",
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
    })
        .then(function (resp) {
            document.getElementById('title').innerHTML = `
               
                            <h1 style="font-size: 4rem">${resp.data.title}  </h1>
                               <h2 style="font-size: 3rem; color: white" class="text-title">Quiz ${resp.data.time_do} min</h2>
                `;
        })
        .catch(function (err) {
            console.log(err);
            // let data = err.response.data;
            // if(data.status == 401){
            //     document.location.href = "../EleaningLayout/index.html";
            // }
            // else if(data.status == 403){
            //     if(token != null){
            //         // XÓA TOKEN KHỎI LOCALSTORAGE
            //         localStorage.removeItem('USER_TOKEN');
            //         document.location.href = "../EleaningLayout/index.html";
            //     }
            // }
        });
}

loadTitleQuiz();

function loadExam() {
    axios({
        url: ` http://localhost:8082/api/user/exam/check/1/${id}`,
        method: "get",
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
    })
        .then(function (resp) {
            let listExam = resp.data;
            let content = ``;
            for (let exam of listExam) {
                content += `
                <tr class="title-body">
                      <th scope="row">Final Quiz</th>
                            <td>${exam.grade}</td>
                            <td style="color: #17a2b8; font-weight: 400;"> <a href="../EleaningLayoutUser/view-feedback.html?id=${exam.exam_id}">View Feedback</a></td>
                            <td>${exam.grade}</td>
                      <td>${exam.time_need}</td>
                </tr>           
                    `;
            }
            document.getElementById('list-exam').innerHTML = content;
        })
        .catch(err => {
            console.log(err);
            // let data = err.response.data;
            // if(data.status == 401){
            //     document.location.href = "../EleaningLayout/index.html";
            // }
            // else if(data.status == 403){
            //     if(token != null){
            //         // XÓA TOKEN KHỎI LOCALSTORAGE
            //         localStorage.removeItem('USER_TOKEN');
            //         document.location.href = "../EleaningLayout/index.html";
            //     }
            // }
        });
}
loadExam();

function QuizShow(){
     window.location.href ="../EleaningLayoutUser/quiz-show.html?id="+id;
}

function submitQuestion() {
    let numberQuestion = document.getElementById("numberQuestion").value;
    let numberQuiz = 0;
    let examDetail = [];
    for(let i=1; i<=numberQuestion;i++){
        examDetail.push({
            "question_id": document.getElementById("question"+i).value,
            "status_ans": Array.from(document.getElementsByName("answer"+i)).find(r => r.checked).value
        });
        if(Array.from(document.getElementsByName("answer"+i)).find(r => r.checked).value == "true"){
            numberQuiz++;
        }
    }

    let examDetailDTO = {
        "course_id": id,
         "examDetailDTO": examDetail,
        "grade": (numberQuiz / numberQuestion) * 10,
        "number_quiz": numberQuiz,
        "time_need": 22,
        "user_id": 1
    }

    axios({
        url: 'http://localhost:8082/api/user/exam',
        method: 'POST',
        data: examDetailDTO,
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
    })
        .then(function (resp) {
            swal("Successfully !", "You clicked the button!", "success").then(function(resp){
                window.location.href = `../EleaningLayoutUser/quiz.html?id=${id}&userId=1`;
            })
        })
        .catch(function (err) {
            console.log(err.response);
            swal("Unsuccessfully !", "You clicked the button!", "error");
        })
}

function Cancel (){
    window.location.href = `../EleaningLayoutUser/quiz.html?id=${id}&userId=1`;
}





