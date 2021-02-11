// alert("Welcome to JavaScript!")
// console.log('Welcome to wbdv course!')

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

var userService = new AdminUserServiceClient()

var users = [
    {username: "CS4550", password: "02", firstname: 23, lastname: "Spring", role: "student"},
    {username: "CS2345", password: "03", firstname: 34, lastname: "Spring", role: "faculty"},
    {username: "CS3456", password: "04", firstname: 45, lastname: "Spring", role: "admin"},
]

function createUser() {
    // alert("JS is working")
    var newUser = {
        username: $usernameFld.val(),
        password: $passwordFld.val(),
        firstname: $firstNameFld.val(),
        lastname: $lastNameFld.val(),
        role: $roleFld.val()
    }

    // here a service instance should be created
    userService.createUser(newUser)
        .then(function (actualUser) {
            users.push(actualUser)
            renderUsers(users)
    })
}

function deleteUser(event) {
    var button = $(event.target)
    var index = button.attr("id")
    var id = users[index]._id
    userService.deleteUser(id)
        .then(function (status) {
            users.splice(index, 1)
            renderUsers(users)
        })
}

var selectedUser = null
function editUser(event) {
    var id = $(event.target).attr("id")
    console.log(id)
    selectedUser = users.find(user => user._id === id)
    $usernameFld.val(selectedUser.username)
    $firstNameFld.val(selectedUser.firstname)
    $lastNameFld.val(selectedUser.lastname)
    $roleFld.val(selectedUser.role)
}

function updateUser() {
    if (selectedUser == null) {
        alert("Please select a user to edit before updating");
    } else {
        selectedUser.username = $usernameFld.val();
        selectedUser.password = $passwordFld.val()
        selectedUser.firstname = $firstNameFld.val()
        selectedUser.lastname = $lastNameFld.val()
        selectedUser.role = $roleFld.val()
        clearInput()

        userService.updateUser(selectedUser._id, selectedUser)
            .then(status => {
                var index = users.findIndex(user => user._id === selectedUser._id)
                users[index] = selectedUser
                renderUsers(users)
                selectedUser = null
            })
    }
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
                        <button id="${i}" class="btn fa-2x fa fa-times wbdv-remove"></button>
                        <button id="${user._id}" class="btn fa-2x fa fa-pencil wbdv-edit"></button>
                    </span>
                </td>
            </tr>
            `)
    }
    // $removeBtn.click(deleteUser)
    // $editBtn.click(editUser)
    $(".wbdv-remove").click(deleteUser)
    $(".wbdv-edit").click(editUser)
}

function clearInput() {
    $('input').each(function () {
        $(this).val('')
    })
}

// function findAllUsers() {
// } // optional - might not need this

// function findUserById() {
// } // optional - might not need this

function main() {
    $tbody = $(".wbdv-tbody")
    // $userRowTemplate = $(".wbdv-template")

    $createBtn = $(".wbdv-create")
    $updateBtn = $(".wbdv-update")
    // $editBtn = $(".wbdv-edit")
    // $removeBtn = $(".wbdv-remove")

    $usernameFld = $("#wbdv-usernameFld")
    $passwordFld = $("#wbdv-passwordFld")
    $firstNameFld = $("#wbdv-firstNameFld")
    $lastNameFld = $("#wbdv-lastNameFld")
    $roleFld = $("#wbdv-roleFld")
    $editFld = $("#wbdv-editFld")

    // $(".wbdv-hidden").hide()

    $createBtn.click(createUser)
    $updateBtn.click(updateUser)
    // $updateBtn.click(clearInput)
    // $removeBtn.click(deleteUser)
    // $editBtn.click(editUser)

    userService.findAllUsers().then(function (actualUsers) {
        users = actualUsers
        renderUsers(users)
    })
}

$(main);
