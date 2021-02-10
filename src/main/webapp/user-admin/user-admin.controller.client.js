// alert("Welcome to JavaScript!")
// console.log('Welcome to wbdv course!')

(function () {
    // var $tableRows
    var $userRowTemplate
    var $tbody

    var $createBtn
    var $editBtn
    var $updateBtn
    var $removeBtn

    var $usernameFld
    var $passwordFld
    var $firstNameFld
    var $lastNameFld
    var $roleFld
    var $editFld

    var userService = new AdminUserServiceClient();

    var users = [
        {username: "CS4550", password: "02", firstname: 23, lastname: "Spring", role: "student"},
        {username: "CS2345", password: "03", firstname: 34, lastname: "Spring", role: "faculty"},
        {username: "CS3456", password: "04", firstname: 45, lastname: "Spring", role: "admin"},
    ]

    function createUser() {

    }

    function deleteUser() {
    }

    function selectUser() {
    }

    function updateUser() {
    }

    function renderUsers(users) {
    }

    function findAllUsers() {
    } // optional - might not need this

    function findUserById() {
    } // optional - might not need this

    function main() {
        $tbody = $(".wbdv-tbody")
        $userRowTemplate = $(".wbdv-template")

        $createBtn = $(".wbdv-create")
        $updateBtn = $(".wbdv-update")
        $editBtn = $(".wbdv-edit")
        $removeBtn = $(".wbdv-remove")

        $usernameFld = $("usernameFld")
        $passwordFld = $("passwordFld")
        $firstNameFld = $("firstNameFld")
        $lastNameFld = $("lastNameFld")
        $roleFld = $("roleFld")
        $editFld = $("editFld")

        // $(".wbdv-hidden").hide()


    }

    $(main);

})();

