var loginAPi = "http://localhost:8083/api/auth/signin";
var adminAPI = "http://localhost:8083/api/test/admin";
// var token = localStorage.getItem("TOKEN");
function login() {
//   Promise.all([getAccount(), permission()])
//     .then((results) => {
//       const acct = results[0];
//       const perm = results[1];
      
//     })
//     .catch((err) => {
//       if (err.response.status == 400 || err.response.status == 401) {
//         swal("Unsuccessfull !", "Account Invalid !", "error");
//       }
//     });

  const email = document.querySelector('[name="email"]').value;
  const password = document.querySelector('[name="password"]').value;
  const loginObject = {
      username:email,
      password:password
  }
  axios.post(loginAPi,loginObject)
      .then(res =>{
          swal("Good job!", "You clicked the button!", "success").then((res=>{
            //   localStorage.setItem('TOKEN', res.loginObject);
              document.location.href = "http://127.0.0.1:5500/Elearning/index.html";
          }))
      })
      .catch(function(err){
          if(err.response.status==400 || err.response.status==401){
              swal("Unsuccessfull !", "Account Invalid !", "error");
          }
      })
}

function getAccount() {
  const email = document.querySelector('[name="email"]').value;
  const password = document.querySelector('[name="password"]').value;
  const loginObject = {
    username: email,
    password: password,
  };
  axios
    .post(loginAPi, loginObject)
    .then((res) => {
      swal("Good job!", "You clicked the button!", "success").then((res) => {
        localStorage.setItem("TOKEN", res.loginObject);
        document.location.href =
        "../../../user-index.html";
      });
    })
    .catch(function (err) {
      if (err.response.status == 400 || err.response.status == 401) {
        swal("Unsuccessfull !", "Account Invalid !", "error");
      }
      if(err.response.status != 401){
      
      }
    });
}

function permission() {
    let token = localStorage.getItem('TOKEN');
  axios
    .get(adminAPI, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
    .then((res) => {
      document.location.href =
        "../../../user-index.html";
    })
    .catch((err) => {
      console.log(err);
    //   let data = err.res.data;
      if (err.response.status == 401) {
        swal("Unsuccessfull !", "Account Invalid !", "error");
      } else if (err.response.status == 403) {
        alert("not have access !");
      }
    });
}

// user -->12345678
// mod -->12345678
// admin -->12345678
// cho user dang nhap vo quyen nao thi se cho quyen do -->get /api/test/all
