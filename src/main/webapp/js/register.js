function Check() {
    return passwordCheck() && emailCheck();
}

function passwordCheck() {
    var rs_userpwd = document.getElementById("rs_userpwd").value;
    var rs_qruserpwd = document.getElementById("rs_qruserpwd").value;
    if (rs_userpwd !== rs_qruserpwd) {
        alert("���飡������������벻һ��!");
        return false;
    }
    return true;
}

function emailCheck() {
    var rs_email = document.getElementById("rs_email").value;
    var emailPattern = /^[A-Za-z0-9+_.-]+@(.+)$/;
    if (!emailPattern.test(rs_email)) {
        alert("���飡�����ʽ����ȷ!");
        return false;
    }
    return true;
}

