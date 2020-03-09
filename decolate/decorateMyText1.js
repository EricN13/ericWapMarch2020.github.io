"use strict"

function btnClicked() {

  alert("Hello world ");
  setInterval(increaseFontSize, 500);
}

// this function will be trigger after click bigger text
function increaseFontSize() {
  var area= document.getElementById("text-area");
  area.style.fontSize = parseInt(window.getComputedStyle(area)
    .getPropertyValue("font-size")) + 2 + "px";
  document.body.style.backgroundImage = "url('http://www.cs.washington.edu/education/courses/190m/CurrentQtr/labs/6/hundred-dollar-bill.jpg')";
}

//Will be trigger after click bling
function onCbxChanged(state) {
  alert("checkbox changed");
  var area = document.getElementById("text-area");
  area.style.fontWeight = "bold";
  if (document.getElementById("checkbox").checked) {
    area.style.fontWeight = "bold";
    area.style.color = "green";
    area.style.textDecoration = "underline";
  } else {
    area.style.fontWeight = "";
    area.style.color = "";
    area.style.textDecoration = "";
  }
}
