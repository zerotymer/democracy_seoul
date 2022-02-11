
const createCard = function (data) {
    let cardDiv = document.createElement('div');
    cardDiv.classList.add('card-item', data.CATEGORY);

    // category div
    var div = cardDiv.appendChild(document.createElement('div'));
    div.classList.add('category');
    switch(data.CATEGORY) {
        case 'suggest':     div.innerText = '제안'; break;
        case 'discussion':  div.innerText = '토론'; break;
        case 'survey':      div.innerText = '설문'; break;
    }
    
    // title div
    var div = cardDiv.appendChild(document.createElement('div'));
    div.classList.add('title');
    div.innerText = data.TITLE;

    // content div
    var div = cardDiv.appendChild(document.createElement('div'));
    div.classList.add('content');
    div.innerHTML = data.CONTENT;

    // thumbnail div
    var div = cardDiv.appendChild(document.createElement('div'));
    div.classList.add('thumbnail');
    var img = div.appendChild(document.createElement('img'));
    img.src = data.THUMBNAIL;
    img.alt = '미리보기';

    // icons div
    var div = cardDiv.appendChild(document.createElement('div'));
    div.classList.add('icons');

    var icon = div.appendChild(document.createElement('object'));
    icon.classList.add('icon', 'hits', 'auto-hidden');
    var span = div.appendChild(document.createElement('span'))
    span.innerText = data.HITCOUNT;

    var icon = div.appendChild(document.createElement('object'));
    icon.classList.add('icon', 'heart');
    var span = div.appendChild(document.createElement('span'))
    span.innerText = data.HEARTCOUNT;

    var icon = div.appendChild(document.createElement('object'));
    icon.classList.add('icon', 'comment');
    var span = div.appendChild(document.createElement('span'))
    span.innerText = data.COMMENTCOUNT;

    var icon = div.appendChild(document.createElement('object'));
    icon.classList.add('icon', 'calendar', 'auto-hidden');
    var span = div.appendChild(document.createElement('span'))
    span.innerText = `${data.STARTDATE} ~ ${data.ENDDATE}`;

    cardDiv.addEventListener('click', function () {
        document.querySelectorAll('.card-item').forEach( item => 
            (item == this) || item.classList.remove('expand')
        );
        this.classList.toggle('expand');
    });

    document.getElementById('card-container').appendChild(cardDiv);
}

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