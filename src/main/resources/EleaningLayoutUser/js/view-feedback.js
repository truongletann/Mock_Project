let urlParam = new URLSearchParams(window.location.search);
let id = urlParam.get("id");

function loadViewFeedBack(){
    axios({
        url: `http://localhost:8082/api/user/exam-detail/1`,
        method: 'GET',
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
    })
        .then(function (resp) {
           let  listQuestion = resp.data;
           console.log(listQuestion);
           let  content  = ``;
           let No = 1;
           for ( let feedback of  listQuestion ){
              let contentAnswer = '';
              for (let answer of feedback.questionDTO.listAns)

              {
                  if (answer.is_right == true){
                      contentAnswer +=`

                     <li className="content-item">
                                   <input type="radio" name=""/>
                                   <span> ${answer.ans_content}</span>
                     </li>`;
                  }
               }

               content+=  `
                          <div class="content">
                            <h5 class="question-number">${No}</h5>
                            <p class="question-content" >
                               ${feedback.questionDTO.question_content}
                            </p>
                        </div>
                        <ul class="content-list" >
                        
                            ${feedback.status_ans == true ? `<h1 style=color:green>sds</h1>` :`<h1 style=color:red>dsd</h1>`   }
                        </ul>
                    </div>
                `;
               No++;
              }
           document.getElementById('view-feedback').innerHTML = content;
        })
        .catch(function (err) {
            console.log(err.response);
        });
        }

loadViewFeedBack();