function getInfo() {
    // let token = localStorage.getItem('USER_TOKEN');
    axios({
        url:`http://localhost:8082/api/admin/user`,
        method: 'get',
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
    })
    .then(function(resp){
        let content = '';
        let listUser = resp.data;
        let No = 1;
        
        for(let user of listUser){
            content += `
            <tr class="account">
                <th>${No}</th>
                <td>${user.full_name}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.status ===true ?
                  '<h6 style ="text-align: center;border-radius: 2px;border: 1px solid #ddd; width: 65px; height: 30px;padding: 5px; margin-right: -12px;background-color: #fe9365;">Active</h6>' : 
                  '<h6 style ="text-align: center;border-radius: 2px;border: 1px solid #ddd; width: 65px; height: 30px;padding: 5px; margin-right: -12px;background-color: #2196f3;" >Inactive</h6>'}
               </td>
               <td>
                   <a href="javascript:void(0)" class="btn btn-sm btn-danger btn-round py-1 font-weight-bold" onclick="remove(${user.user_id })">Delete</a>
                   <a href="javascript:void(0)" class="btn btn-sm btn-primary btn-round py-1 font-weight-bold" onclick="active(${user.user_id })">Open Account</a>
               </td>
               
            </tr>
            `;
            No++;
        }
        document.getElementById('tBody').innerHTML = content;
    })
    .catch(function(err){
        console.log(err)
        // let data = err.response.data;

        // if(data.status==401){
        //     // window.location.href = "/login.html";
        // }
        // else if(data.status==403){
        //     alert('not have access !')
        // }
    })
}

getInfo();

function remove(id){
  swal({
      title: "Are you sure?",
      // text: "Once deleted, you will not be able to recover this imaginary file!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      // var removeAccount = document.querySelector('.account').classList.add('invalid');
  
      if (willDelete ) {
          let token = localStorage.getItem('USER_TOKEN');
      axios({
          url:`http://localhost:8082/api/admin/user/delete/${id}`,
          method: 'put',
          // headers: {
          //     'Authorization': `Bearer ${token}`
          // }
      })
      .then(function(resp){
          getInfo();
      })
      .catch(function(err){
          console.log(err)
      })
        swal("Poof! Your Account  has been deleted!", {
          icon: "error",
        });
      } 
     
    });  
}
function active(id){
  swal({
      title: "Are you sure delete ?",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      // var active = document.querySelector('.account').classList.remove('invalid');
      if (willDelete ) {
          let token = localStorage.getItem('USER_TOKEN');
      axios({
          url:`http://localhost:8082/api/admin/user/active/${id}`,
          method: 'put',
          // headers: {
          //     'Authorization': `Bearer ${token}`
          // }
      })
      .then(function(resp){
          getInfo();
      })
      .catch(function(err){
          console.log(err)
      })
      
        swal("Poof! Open Account Success ", {
          icon: "success",
        });
      } 
     
    }); 
}

