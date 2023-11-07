getUserName();
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
        document.getElementById("container").innerHTML = userContainer();
    }

    function userContainer() {
        return `
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
                                        <input type="text" class="form-control" placeholder="" aria-label="First name" id="name">
                                    </div>
                                    <div class="w-100"></div>
                                    <!-- Phone number -->
                                    <div class="col-md-6">
                                        <label class="form-label">Phone number *</label>
                                        <input type="text" class="form-control" placeholder="" aria-label="Phone number" id="phone">
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
                                        <input type="email" class="form-control" id="email" value="example@homerealty.com">
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="form-group col-md-4">
                                        <label for="inputState">State</label>
                                        <select id="inputState" class="form-control">
                                            <option selected>Gender</option>
                                            <option>Male</option>
                                            <option>Female</option>
                                        </select>
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col-md-6">
                                        <label class="form-label">Address</label>
                                        <input type="text" class="form-control" placeholder="" aria-label="Phone number" id="address">
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
`;

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
        `;
    }
}

function changePass() {
    let newPassword = document.getElementById("exampleInputPassword2")
    let confirmNewPassword = document.getElementById("exampleInputPassword3")
    if (newPassword === confirmNewPassword) {
        let data = {
            id: localStorage.getItem("id"), pass: document.getElementById("exampleInputPassword3").value
        }
        axios.put('http://localhost:8080/users/edit', data).then(() => {
            alert("đổi mật khẩu thành công")
        });
    } else {
        alert("Nhập lại mật khẩu chưa trùng khớp");
    }
}

function getUserName() {
    let id = localStorage.getItem("id");
    console.log(id)
    // Gửi yêu cầu HTTP GET đến API
    axios.get(`http://localhost:8080/users/${id}`).then((response) => {
        if (response.status === 200) {
            // Lấy tên user từ phản hồi
            const username = response.data.username;
            console.log(username);
            document.getElementById("username-content").innerHTML = username;
            document.getElementById("userImg").innerHTML = `<img style="width: 30px; border-radius: 50%" id="user-image" src="${response.data.image}" alt="User Image">`;
            // Hiển thị ảnh người dùng
            console.log(response.data.image)
            if (userImage) {

            }
        }
    });
}

function editInfo() {
    const fileInput = document.getElementById("customFile");
    // Lấy file hình ảnh từ input
    const file = fileInput.files[0];

    // Tạo tham chiếu đến nơi bạn muốn lưu trữ ảnh trong Storage
    const storageRef = storage.ref("kien/" + file.name);
    let gender;
    // Tải file lên Firebase Storage
    storageRef.put(file).then((snapshot) => {
        console.log("Uploaded a file!");

        // Lấy URL của ảnh sau khi đã tải lên
        storageRef.getDownloadURL().then((url) => {
            console.log(url);
            let data = {
                id: localStorage.getItem("id"),
                name: document.getElementById('name').value,
                address: document.getElementById('address').value,
                phone: document.getElementById('phone').value,
                email: document.getElementById('email').value,
                birthday: document.getElementById('birthday').value, // gender : gender,
                image: url
            }
            console.log(data)
            axios.put('http://localhost:8080/users/edit', data).then(() => {
                alert("sửa thành công")
            });
        });
    });
}

