function initCardContainer() {
    let cardItems = document.querySelectorAll('.card-item');
    // set toggle class
    cardItems.forEach( item => {
        // OnClick Event
        item.addEventListener('click', function () {
            document.querySelectorAll('.card-item').forEach( item => 
                (item == this) || item.classList.remove('expand')
            );
            this.classList.toggle('expand');
        });
    });
}

initCardContainer();