var a = 0;
function mouseOver()
{
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const pass = document.getElementById('pass').value;

   // const tick = documnet.querySelector('#check');

    if ((name == "" || email=="" || pass == "") && a == 0)
    {
        buttonMoveLeft();
        a = 1;
        return false;
    }

    if ((name == "" || email == "" || pass == "") && a == 1)
    {
        buttonMoveRight();
        a = 2;
        return false;
    }

    if ((name == "" || email == "" || pass == "") && a == 2)
    {
        buttonMoveLeft();
        a = 1;
        return false;
    }

    else
    {
        const but = document.getElementById('btn');
        but.style.cursor = 'pointer';
        but.style.backgroundColor = 'purple';
        return false;
    };

};

function buttonMoveLeft()
{
    const button = document.getElementById('btn');
    button.style.transform = 'translateX(-205px)';

};

function buttonMoveRight()
{
    const button = document.getElementById('btn');
    button.style.transform = 'translateX(0%)';

};

function resetBtn() {
    const button = document.getElementById('btn');
    button.style.transform = 'translateX(0%)';

};



