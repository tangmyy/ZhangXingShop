/**
 *
 */
document.addEventListener('DOMContentLoaded', (event) => {
    const selectAllCheckbox = document.getElementById('select-all');
    const itemCheckboxes = document.querySelectorAll('.item-checkbox');

    // ����ȫѡ��ı仯
    selectAllCheckbox.addEventListener('change', function() {
        const isChecked = selectAllCheckbox.checked;
        itemCheckboxes.forEach(checkbox => {
            checkbox.checked = isChecked;
        });
        updateAllCheckedBox(isChecked);
    });

    // ����ÿ����ѡ��ı仯
    itemCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            const allChecked = Array.from(itemCheckboxes).every(checkbox => checkbox.checked);
            selectAllCheckbox.checked = allChecked;
            updateByCheckedBox(checkbox.dataset.id);
        });
    });
});

function updateByCheckedBox(commodityId) {
    fetch(`ShopCartController?commodityId=${commodityId}&serviceType=updateByCheckedBox`)
        .then(response => response.text())
        .then(data => {
            console.log(data);
            // ���Ը�����Ҫ����ҳ��������������
        })
        .catch(error => console.error('Error:', error));
}

function updateAllCheckedBox(isChecked) {
    fetch(`ShopCartController?serviceType=updateAllCheckedBox&commodityId=${isChecked}`)
        .then(response => response.text())
        .then(data => {
            console.log(data);
            // ���Ը�����Ҫ����ҳ��������������
        })
        .catch(error => console.error('Error:', error));
}

function addToCart(commodityId) {
    fetch(`ShopCartController?commodityId=${commodityId}&serviceType=addToCart`, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            if (data.loggedIn === false) {
                window.location.href = "login.jsp";
            } else if (data.success) {
                // ���빺�ﳵ�ɹ�����ת�����ﳵҳ��
                window.location.href = "myshopcart.jsp";
            } else {
                alert("���빺�ﳵʧ�ܣ����Ժ����ԣ�");
            }
        })
        .catch(error => console.error('Error:', error));
}

function remove(commodityId) {
    fetch(`ShopCartController?commodityId=${commodityId}&serviceType=remove`, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            if (data.loggedIn === false) {
                window.location.href = "login.jsp";
            } else if (data.success) {
                var itemElement = document.querySelector(`.item[data-id="${commodityId}"]`);
                itemElement.remove();
                document.querySelector('.total-price').textContent = data.total;
                if (data.cartEmpty) {
                    document.querySelector('main').innerHTML = '<h1>���ﳵ�տ���Ҳ���Ͽ�ȥ���</h1>';
                }
            } else {
                alert("�Ƴ�ʧ�ܣ����Ժ����ԣ�");
            }
        })
        .catch(error => console.error('Error:', error));
}

function updateByNum(commodityId, changeNum) {
    // ��ȡ��ǰ��Ʒ����
    var itemElement = document.querySelector(`.item[data-id="${commodityId}"]`);
    var Num = parseInt(itemElement.getAttribute('data-num'), 10);

    // ������Ϊ1�����û��������ʱ��������ʾ��
    if (Num === 1 && changeNum === -1) {
        alert("ע�⣺���������������ټ��ٿ���");
        return;
    }

    // ����Ajax����
    fetch(`ShopCartController?commodityId=${commodityId}&serviceType=updateByNum&changeNum=${changeNum}`, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            if (data.loggedIn === false) {
                window.location.href = "login.jsp";
            } else if (data.success) {
                var newNum = Num + changeNum;
                itemElement.setAttribute('data-num', newNum);
                itemElement.querySelector('.num-display').textContent = newNum;
                document.querySelector('.total-price').textContent = data.total;
            } else {
                alert("��������ʧ�ܣ����Ժ����ԣ�");
            }
        })
        .catch(error => console.error('Error:', error));
}



// function addToCart(commodityId){
//     location.href = "ShopCartController?commodityId=" +commodityId +"&serviceType=addToCart";
// }
//
// function remove(commodityId){
//     location.href = "ShopCartController?commodityId=" +commodityId +"&serviceType=remove"
// }
// function updateByNum(commodityId, changeNum){
//     // ��ȡ������ĳ����ֵ�� Ԫ�� ����JavaScript�У�����ʹ�� dataset �����������Զ����������ԣ�
//     var input = document.querySelector(`input[data-id="${commodityId}"]`);
//     // ��ȡ��Ԫ�ص�����ֵ
//     var Num = parseInt(input.getAttribute('data-num'), 10);
//     // ������Ϊ1�����û��������ʱ��������ʾ��
//     if (Num === 1 && changeNum === -1) {
//         alert("ע�⣺���������������ڼ��ٿ���");
//         return;
//     }
//     location.href = "ShopCartController?commodityId=" + commodityId + "&serviceType=updateByNum&changeNum=" + changeNum;
// }