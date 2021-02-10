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

    // var userService = new AdminUserServiceClient();

    var users = [
        {username: "CS4550", password: "02", firstname: 23, lastname: "Spring", role: "student"},
        {username: "CS2345", password: "03", firstname: 34, lastname: "Spring", role: "faculty"},
        {username: "CS3456", password: "04", firstname: 45, lastname: "Spring", role: "admin"},
    ]

    function createUser() {
        // alert("JS is working")
        var newCourse = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstname: $firstNameFld.val(),
            lastname: $lastNameFld.val(),
            role: $roleFld.val()
        }

        // here a service instance should be created

        users.push(newCourse)
        renderUsers(users)
    }

    function deleteUser(event) {
        var button = $(event.target)
        var index = button.attr("id")
        var id = users[index]._id
    }

    function editUser() {
    }

    function updateUser() {
    }

    function renderUsers(users) {
        $tbody.empty()
        for (var i = 0; i < users.length; ++i) {
            var user = users[i]
            $tbody
                .prepend(`
                <tr class="wbdv-user">
                    <td class="wbdv-username">${user.username}</td>
                    <td>&nbsp;</td>
                    <td class="wbdv-first-name">${user.firstname}</td>
                    <td class="wbdv-last-name">${user.lastname}</td>
                    <td class="wbdv-role">${user.role}</td>
                    <td class="wbdv-actions">
                        <span class="pull-right">
                            <button id="${i}" btn fa-2x fa fa-times wbdv-remove"></button>
                            <button id="${course._id}" class="btn fa-2x fa fa-pencil wbdv-edit"></button>
                        </span>
                    </td>
                </tr>
                `)
        }
        $(".wbdv-remove").click(deleteUser)
        $(".wbdv-edit").click(editUser)
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

        $usernameFld = $("#usernameFld")
        $passwordFld = $("#passwordFld")
        $firstNameFld = $("#firstNameFld")
        $lastNameFld = $("#lastNameFld")
        $roleFld = $("#roleFld")
        $editFld = $("#editFld")

        // $(".wbdv-hidden").hide()

        $updateBtn.click(updateUser)
        $createBtn.click(createUser)
        $removeBtn.click(deleteUser)
        $editBtn.click(editUser)

        renderUsers(users)
    }

    $(main);

})();

