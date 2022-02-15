const loadCards = function () {
    let container = document.getElementById('card-container');
    while (container.firstChild) {
        container.removeChild(container.firstChild);
    }

    jQuery.ajax({
        url: '/main/list.ajax',
        type: 'GET',
        datatype: 'json',
        success: out => out.map(createCard),
        error: e => console.log('ajax 통신 실패')
    });
}


loadCards();