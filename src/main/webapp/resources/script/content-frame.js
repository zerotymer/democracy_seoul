window.addEventListener('load', function() {
    let menuLists = document.querySelectorAll('.menubar-list');

    menuLists.forEach( function (element) {
        element.addEventListener('click', function() {
            document.querySelectorAll('.menubar-list').forEach( 
                item => item == element || item.classList.remove('menulist--show')
            );
            element.classList.toggle('menulist--show');
        });
    });
});