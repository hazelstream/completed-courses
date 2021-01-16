let imgArray = new Array;
let imgString;
let currentImageIndex = 0;

for(let i = 1; i <= 8; i++) {
    imgString = 'images/image' + i + '.jpg';
    imgArray[i - 1] = imgString;
}

document.getElementsByClassName("arrow-left")[0].addEventListener("click", scrollLeft);
document.getElementsByClassName("arrow-right")[0].addEventListener("click", scrollRight);

function scrollLeft() {
    currentImageIndex--;
    if(currentImageIndex < 0){
        currentImageIndex = 7;
    }
    document.getElementById("catImg").src = imgArray[currentImageIndex];   
}

function scrollRight() {
    currentImageIndex++;
    if (currentImageIndex > 7) {
        currentImageIndex = 0;
    }
    document.getElementById("catImg").src = imgArray[currentImageIndex];    
}



