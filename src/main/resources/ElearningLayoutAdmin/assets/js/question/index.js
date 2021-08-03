let token = localStorage.getItem('USER_TOKEN');

let urlParam = new URLSearchParams(window.location.search);
let id = urlParam.get('id');

function loadQuestion() {
  axios({
    url: `http://localhost:8082/api/admin/question/by-course/${id}`,
    method: 'get',
      headers: {
          "Authorization": `Bearer ${token}`
      }
  })
    .then(function (resp) {
      let listQuestion = resp.data;
      console.log(listQuestion);
      let content = '';
      let No = 1;
      for (let question of listQuestion) {
        let contentAnswer = '';
        for (let answer of  question.listAns){
          contentAnswer +=`
          <div class="quiz-checkbox">
          <li>
              <p class="quiz-answer" ${answer.is_right == true ? 'style="color:#0ac282;font-size:1rem" ' :'style="color:black"'}>
                 ${answer.ans_content}
              </p>
          </li> 
      </div>
          `;
        }
        content += ` 
        <tr>
        <td>${No}</td>
        <td >
        <h6 class="text-danger font-weight-bold quiz-answer" style="width: 700px;">${question.question_content} </h6> 
        <ol class="ol-answer">
         `+contentAnswer+`
        </ol>
        </td>
        <td>
            <a href="../ElearningLayoutAdmin/question-edit.html?id=${question.question_id}"
                class="btn btn-sm btn-info btn-round py-1 font-weight-bold">Edit</a>
            <button href="javascript:void(0)" onclick=removeQuestion(${question.question_id})
                class="btn btn-sm btn-danger btn-round py-1 font-weight-bold">Delete</button>
        </td>
       
    </tr> 
        `;
        No++;
      }
      document.getElementById("tbodyQuestion").innerHTML = content;
    })
    .catch(function (err) {
        let data = err.response.data;
        if(data.status == 401){
            document.location.href = "./login.html";
        }
        else if(data.status == 403){
            if(token != null){
                // XÓA TOKEN KHỎI LOCALSTORAGE
                localStorage.removeItem('USER_TOKEN');
                document.location.href = "./login.html";
            }
        }
    });
}

loadQuestion();


function removeQuestion(questionID) {
  swal({
    title: "Are you sure?",
    // text: "Once deleted, you will not be able to recover this question!",
    icon: "warning",
    buttons: true,
    dangerMode: true,
  }).then((willDelete) => {
    if (willDelete) {
      axios({
        url: `http://localhost:8082/api/admin/question/${questionID}`,
        method: "delete",
        headers: {
            "Authorization": `Bearer ${token}`
        }
      })
        .then(function (resp) {
           
          swal("Successful !", "You clicked the button!", "success").then(
            function (resp) {
                window.location.href = "../ElearningLayoutAdmin/question-index.html?id=" + id;
            }
          );
        })
        .catch(function (err) {
          console.log(err);
          swal("Unsuccessful !", "You clicked the button!", "error");
        });

      swal("Poof! Your question has been deleted!", {
        icon: "success",
      });
     }
     
  });
}

function addNewQuestion(){
  window.location.href = "../ElearningLayoutAdmin/question-add.html?id=" + id;
}

