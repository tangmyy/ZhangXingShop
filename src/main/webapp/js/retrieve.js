function passwordCheck() {
    var Ret_userpwd = document.getElementById("Ret_userpwd").value;
    var Ret_qruserpwd = document.getElementById("Ret_qruserpwd").value;

    if (Ret_userpwd !== Ret_qruserpwd) {
        alert("���飡������������벻һ��!");
        return false;
    }

    return true;
}


