const gnbSlide = function() {
    const menubtn = document.getElementById('menubtn');
    const nav = document.querySelector('.gnb .menu');
    const navLinks = document.querySelectorAll('.gnb .menuitem');

    menubtn.addEventListener('click', function() {
        // Toggle Nav
        nav.classList.toggle('nav-active');

        // Animate Links
        navLinks.forEach( (link, index) => {
            link.style.animation = link.style.animation ? '' : `navLinkFade 0.5s ease forwards ${index / 7 + 0.5}s`;
        });
    });

};

window.addEventListener('load', function() {
    let menuitems = document.getElementsByClassName('menuitem');
    Array.from(menuitems).forEach( function(item) {
        item.addEventListener('click', function () {
            document.querySelectorAll('.menuitem').forEach( item => item.classList.remove('active'));
            item.classList.toggle('active');
        });
    });
});





gnbSlide();

