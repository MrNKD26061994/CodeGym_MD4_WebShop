function adminForm() {
    tempContainer();

    function tempContainer() {
        axios.get('http://localhost:8080/users')
            .then((response) => {
                const data = response.data;
                const container = document.getElementById("container");

                const activeUsers = data.filter((user) => user.status === 0);
                const disabledUsers = data.filter((user) => user.status === 1);
                let str = `
                    <div class="colorlib-product">
                        <div class="container">
                            <div class="row">
<div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
<input type="text" id="searchInput" placeholder="Search by name">
</div>
                            </div>
                            <div class="row row-pb-md">
                                <div class="col-md-6">
                                    <h3>Active Users</h3>
                                    <div class="row">`;

                activeUsers.forEach((user) => {
                    str += createProductCard(user, false);
                });

                str += `       </div>
                                </div>
                                <div class="col-md-6">
                                    <h3>Disabled Users</h3>
                                    <div class="row">`;

                disabledUsers.forEach((user) => {
                    str += createProductCard(user, true);
                });

                str += `
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <p><a href="#" class="btn btn-primary btn-lg">Shop All Products</a></p>
                        </div>
                    </div>
                </div>
            </div>`;

                container.innerHTML = str;
            })
            .catch((error) => {
                console.error("Error fetching data:", error);
            });
    }

    function createProductCard(user, isDisabled) {
        const statusText = isDisabled ? "Disabled" : "Active";
        const actionText = isDisabled ? "Enable" : "Disable";
console.log(user)
        return `
            <div class="col-lg-6 mb-4 text-center">
                <div class="product-entry border">
                    <a href="#" class="prod-img">
                        <img src="${user.image}" class="img-fluid" alt="Free html5 bootstrap 4 template">
                    </a>
                    <input type="hidden" id="id" value="${user.id}">
                    <div class="desc">
                        <h2><a href="#">${user.username}</a></h2>
                        <!--Modal: Login with Avatar Form-->
<div  class="modal fade btn" id="modalLoginAvatar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
    <!--Content-->
    <div class="modal-content">

      <!--Header-->
      <div class="modal-header">
        <img src="${user.image}" alt="avatar" class="rounded-circle img-responsive" style="width: 100%; justify-content: center">
      </div>
      <!--Body-->
      <div class="modal-body text-center mb-1">

        <h5 class="mt-1 mb-2">${user.username}</h5>

        <div class="md-form ml-0 mr-0">
                  <label data-error="wrong" data-success="right" for="form29" class="ml-0">Full name</label>
          <input type="text" id="name" class="form-control form-control-sm validate ml-0" value="${user.name}">
        </div>
<div class="md-form ml-0 mr-0">
    <label data-error="wrong" data-success="right" for="phone" class="ml-0">Phone</label>
    <input type="tel" id="phone" class="form-control form-control-sm validate ml-0" value="${user.phone}" pattern="[0-9]{10}">
</div>

<div class="md-form ml-0 mr-0">
    <label data-error="wrong" data-success="right" for="email" class="ml-0">Email</label>
    <input type="email" id="email" class="form-control form-control-sm validate ml-0" value="${user.email}" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" required>
</div>
                <div class="md-form ml-0 mr-0">
                          <label data-error="wrong" data-success="right" for="form29" class="ml-0">Address</label>
          <input type="text" id="address" class="form-control form-control-sm validate ml-0" value="${user.address}" >
        </div>
<div class="md-form ml-0 mr-0">
    <label for="gender" class="ml-0">Gender</label>
    <select id="gender" class="form-control form-control-sm validate ml-0">
        <option value="1" ${user.gender === 1 ? "selected" : ""}>Nam</option>
        <option value="0" ${user.gender === 0 ? "selected" : ""}>Nữ</option>
    </select>
</div>
                      <div class="md-form ml-0 mr-0">
                                <label data-error="wrong" data-success="right" for="form29" class="ml-0">User name</label>
          <input type="text" id="username" class="form-control form-control-sm validate ml-0" value="${user.username}" >

        </div>
<div class="text-center mt-4">
    <button class="btn btn-cyan mt-1" onclick="confirmEdit()">Edit <i class="fas fa-sign-in ml-1"></i></button>
</div>
      </div>

    </div>
    <!--/.Content-->
  </div>
</div>
<!--Modal: Login with Avatar Form-->

<div class="text-center">
  <button style="border: solid black" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#modalLoginAvatar">
    Edit</button>
</div>
                        <button class="price" onclick="${isDisabled ? 'enableUser' : 'disableUser'}(${user.id}, this)">${actionText}</button>
                    </div>
                </div>
            </div>`;
    }
}

function confirmEdit() {
    const phoneInput = document.getElementById('phone');
    const emailInput = document.getElementById('email');
    const phonePattern = /[0-9]{10}/;
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    const isPhoneValid = phonePattern.test(phoneInput.value);
    const isEmailValid = emailPattern.test(emailInput.value);

    if (!isPhoneValid) {
        alert("Số điện thoại không hợp lệ. Vui lòng nhập đúng định dạng 10 số.");
        return;
    }

    if (!isEmailValid) {
        alert("Email không hợp lệ. Vui lòng nhập đúng định dạng email.");
        return;
    }

    const confirmed = window.confirm("Bạn chắc chắn muốn thực hiện thay đổi?");

    if (confirmed) {
        let data = {
            id: document.getElementById('id').value,
            name: document.getElementById('name').value,
            address: document.getElementById('address').value,
            phone: phoneInput.value,
            email: emailInput.value,
            gender: document.getElementById('gender').value,
            username: document.getElementById("username").value
        }
        console.log(data);
        axios.put('http://localhost:8080/users/edit', data).then(() => {
            alert("Cập nhật thành công");
        });
    } else {
        adminForm();
    }
}

function disableUser(id, button) {
    const confirmed = window.confirm("Bạn chắc chắn muốn thực hiện thay đổi?");

    if (confirmed) {
        const data = {
            id: id,
            status: 1
        };

        axios.put('http://localhost:8080/users/edit', data)
            .then(() => {
                button.innerHTML = "Enable";
                button.onclick = function () {
                    enableUser(id, button);
                };
            })
            .catch((error) => {
                console.error("Error disabling user:", error);
            });
    } else {
        adminForm();
    }

}

function enableUser(id, button) {
    const confirmed = window.confirm("Bạn chắc chắn muốn thực hiện thay đổi?");

    if (confirmed) {
        const data = {
            id: id,
            status: 0
        };
        axios.put('http://localhost:8080/users/edit', data)
            .then(() => {
                button.innerHTML = "Disable";
                button.onclick = function () {
                    disableUser(id, button);
                };
            })
            .catch((error) => {
                console.error("Error enabling user:", error);
            });
    } else {
        adminForm();
    }
}




