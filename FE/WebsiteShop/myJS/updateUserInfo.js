getUserName()
//Cấu hình firebase
const firebaseConfig = {
    apiKey: "AIzaSyBYwhcJE-WrIAAePLLEoFJ33ba1D2P38zc",
    authDomain: "kien-b06e6.firebaseapp.com",
    projectId: "kien-b06e6",
    storageBucket: "kien-b06e6.appspot.com",
    messagingSenderId: "234517503542",
    appId: "1:234517503542:web:b1841470b3a52471bac297",
    measurementId: "G-NYS2P0C4YT"
};
firebase.initializeApp(firebaseConfig);

const storage = firebase.storage();

function userInfo() {

    tempContainer();

    function tempContainer() {
        const container = document.getElementById("container");

        let id = localStorage.getItem("id");
        console.log(id)
        // Gửi yêu cầu HTTP GET đến API
        axios.get(`http://localhost:8080/users/${id}`).then((response) => {
            if (response.status === 200) {
                // Lấy tên user từ phản hồi
                let str = `
    <div class="container justify-content-md-center">
        <div class="row">
            <div class="col-12">
                <div class="d-flex">
                    <!-- Page title -->
                    <div class="col-6">
                        <h3>My Profile</h3>
                        <hr>
                    </div>
                    <div class="col-6">
                        <h3 class="btn btn-primary" onclick="changePassForm()">Change password</h3>
                        <hr>
                    </div>
                </div>
                <!-- Form START -->
                <form class="file-upload" enctype="multipart/form-data">
                    <div class="row mb-5 gx-5">
                        <!-- Contact detail -->
                        <div class="w-100"></div>
                        <div class="col-xxl-8 mb-5 mb-xxl-0">
                            <div class="bg-secondary-soft px-4 py-5 rounded">
                                <div class="row g-3">
                                    <h4 class="mb-4 mt-0">Contact detail</h4>
                                    <!-- First Name -->
                                    <div class="w-100"></div>
                                    <div class="col-md-6">
                                        <label class="form-label">Full Name *</label>
                                        <input type="text" class="form-control" placeholder="" aria-label="First name" id="name" value="${response.data.name}">
                                    </div>
                                    <div class="w-100"></div>
                                    <!-- Phone number -->
                                    <div class="col-md-6">
                                        <label class="form-label">Phone number *</label>
                                        <input type="text" class="form-control" placeholder="" aria-label="Phone number" id="phone" value="${response.data.phone}">
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col-md-6">
                                        <label class="form-label">Birthday</label>
                                        <input type="date" class="form-control" placeholder="" aria-label="Phone number" id="birthday">
                                    </div>
                                    <div class="w-100"></div>
                                    <!-- Email -->
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Email *</label>
                                        <input type="email" class="form-control" id="email" value="${response.data.email}">
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="form-group col-md-4">
                                        <label for="inputState">State</label>
    <select id="gender" class="form-control form-control-sm validate ml-0">
        <option value="1" ${response.data.gender === 1 ? "selected" : ""}>Nam</option>
        <option value="0" ${response.data.gender === 0 ? "selected" : ""}>Nữ</option>
    </select>
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col-md-6">
                                        <label class="form-label">Address</label>
                                        <input type="text" class="form-control" placeholder="" aria-label="Phone number" id="address" value="${response.data.address}">
                                    </div>
                                </div> <!-- Row END -->
                            </div>
                        </div>
                        <div class="square position-relative display-2 mb-3"></div>
                        <!-- Upload profile -->
                        <div class="col-xxl-4">
                            <div class="bg-secondary-soft px-4 py-5 rounded">
                                <div class="row g-3">
                                    <h4 class="mb-4 mt-0">Upload your profile photo</h4>
                                    <div class="text-center">
                                        <!-- Image display -->
                                        <img id="profileImage" src="" alt="Profile Image" style="max-width: 100%; max-height: 200px;">
                                        <!-- Image upload -->
                                        <div class="square position-relative display-2 mb-3">
                                        </div>
                                        <!-- Button -->
                                                                            <div class="w-100"></div>
                                        <input type="file" id="customFile" name="file" hidden="" onchange="displayImage(this)">
                                        <label class="btn btn-success-soft btn-block" for="customFile">Upload</label>
                                        <button type="button" class="btn btn-danger-soft" onclick="removeImage()">Remove</button>
                                        <!-- Content -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- Row END -->
                    <!-- Social media detail -->
                    <div class="row mb-5 gx-5">
                        <div class="col-xxl-6 mb-5 mb-xxl-0">
                            <div class="bg-secondary-soft px-4 py-5 rounded">
                                <div class="row g-3">
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- Row END -->
                <!-- button -->
                <div class="gap-3 d-md-flex justify-content-md-center">
                    <button type="button" class="btn btn-primary btn-lg" onclick="editInfo()">Update profile</button>
                </div>
            </form> <!-- Form END -->
        </div>
    </div>
</div>
`
                container.innerHTML = str;
            }
        });

    }
}

// JavaScript function to display the uploaded image
function displayImage(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            var profileImage = document.getElementById('profileImage');
            profileImage.src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
    }
}

// JavaScript function to remove the displayed image
function removeImage() {
    var profileImage = document.getElementById('profileImage');
    profileImage.src = '';
}

function changePassForm() {

    tempContainer();

    function tempContainer() {
        document.getElementById("container").innerHTML = changePassContainer();
    }

    function changePassContainer() {
        return `
<div class="row">
<div class="col-6"></div>
<div class="col-6">
\t\t\t\t<h3 class="btn btn-primary" onclick="userInfo()">My Profile</h3>
</div>
</div>

\t\t\t\t\t<!-- change password -->
\t\t\t\t\t<div class="col-xxl-6">
\t\t\t\t\t\t<div class="bg-secondary-soft px-4 py-5 rounded">
\t\t\t\t\t\t\t<div class="row g-3">
\t\t\t\t\t\t\t\t<h4 class="my-4">Change Password</h4>
 <div class="w-100"></div>
 <div class="w-100"></div>
\t\t\t\t\t\t\t\t<!-- New password -->
\t\t\t\t\t\t\t\t<div class="col-md-6">
\t\t\t\t\t\t\t\t\t<label for="exampleInputPassword2" class="form-label">New password *</label>
\t\t\t\t\t\t\t\t\t<input type="password" class="form-control" id="exampleInputPassword2">
\t\t\t\t\t\t\t\t</div>
 <div class="w-100"></div>
\t\t\t\t\t\t\t\t<!-- Confirm password -->
\t\t\t\t\t\t\t\t<div class="col-md-12">
\t\t\t\t\t\t\t\t\t<label for="exampleInputPassword3" class="form-label">Confirm Password *</label>
\t\t\t\t\t\t\t\t\t<input type="password" class="form-control" id="exampleInputPassword3">
\t\t\t\t\t\t\t\t</div>
                <div class="gap-3 d-md-flex justify-content-md-center">
                    <button type="button" class="btn btn-primary btn-lg" onclick="changePass()">Change password</button>
                </div>
        `;
    }
}

function changePass() {
    let newPassword = document.getElementById("exampleInputPassword2").value
    let confirmNewPassword = document.getElementById("exampleInputPassword3").value
    if (newPassword === confirmNewPassword) {
        let data = {
            id: localStorage.getItem("id"),
            password: confirmNewPassword
        }
        axios.put('http://localhost:8080/users/edit', data).then(() => {
            alert("đổi mật khẩu thành công")
        });
    } else {
        alert("Nhập lại mật khẩu chưa trùng khớp");
    }
}



function editInfo() {
    const fileInput = document.getElementById("customFile");
    const nameInput = document.getElementById("name");
    const phoneInput = document.getElementById("phone");
    const emailInput = document.getElementById("email");
    const addressInput = document.getElementById("address");
    const genderInput = document.getElementById("inputState");

    // Lấy file hình ảnh từ input
    const file = fileInput.files[0];

    // Kiểm tra định dạng số điện thoại (10 chữ số)
    const phonePattern = /^[0-9]{10}$/;
    const isPhoneValid = phonePattern.test(phoneInput.value);

    // Kiểm tra định dạng email
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    const isEmailValid = emailPattern.test(emailInput.value);

    if (!isPhoneValid) {
        alert("Số điện thoại không hợp lệ. Vui lòng nhập đúng định dạng 10 số.");
        return;
    }

    if (!isEmailValid) {
        alert("Email không hợp lệ. Vui lòng nhập đúng định dạng email.");
        return;
    }

    // Tạo tham chiếu đến nơi bạn muốn lưu trữ ảnh trong Storage
    const storageRef = storage.ref("kien/" + file.name);

    // Tải file lên Firebase Storage
    storageRef.put(file).then((snapshot) => {
        console.log("Uploaded a file!");

        // Lấy URL của ảnh sau khi đã tải lên
        storageRef.getDownloadURL().then((url) => {
            console.log(url);
            let data = {
                id: localStorage.getItem("id"),
                name: nameInput.value,
                address: addressInput.value,
                phone: phoneInput.value,
                email: emailInput.value,
                gender: genderInput.value,
                image: url
            }
            console.log(data)
            axios.put('http://localhost:8080/users/edit', data).then(() => {
                alert("Sửa thông tin thành công");
            });
        });
    });
}

