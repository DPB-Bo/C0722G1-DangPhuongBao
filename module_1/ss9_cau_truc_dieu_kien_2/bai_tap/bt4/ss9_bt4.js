imgSrc1 = document.getElementById("imgSrc1");
imgSrc2 = document.getElementById("imgSrc2");
imgSrc3 = document.getElementById("imgSrc3");
imgSrc4 = document.getElementById("imgSrc4");
imgSrc5 = document.getElementById("imgSrc5");
const MESSAGE_WIN = "Bạn đã thắng";
const IMG_CAT_1 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/funny-cat1_part1x1.jpg";
const IMG_CAT_2 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/funny-cat1_part2x1.jpg";
const IMG_CAT_3 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/funny-cat1_part3x1.jpg";
const IMG_CAT_4 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/funny-cat1_part4x1.jpg";
const IMG_CAT_5 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/funny-cat1_part5x1.jpg";
const IMG_MONKEY_1 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/monkey_part1x1.jpg";
const IMG_MONKEY_2 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/monkey_part2x1.jpg";
const IMG_MONKEY_3 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/monkey_part3x1.jpg";
const IMG_MONKEY_4 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/monkey_part4x1.jpg";
const IMG_MONKEY_5 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/monkey_part5x1.jpg";
const IMG_PANDA_1 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/panda_swap_part1x1.jpg";
const IMG_PANDA_2 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/panda_swap_part2x1.jpg";
const IMG_PANDA_3 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/panda_swap_part3x1.jpg";
const IMG_PANDA_4 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/panda_swap_part4x1.jpg";
const IMG_PANDA_5 =
  "/ss9_cau_truc_dieu_kien_2/bai_tap/bt4/ss9_bt4_img/panda_swap_part5x1.jpg";

function changeImage(position) {
  switch (position) {
    case 1:
      switch (imgSrc1.getAttribute("src")) {
        case IMG_CAT_1:
          imgSrc1.setAttribute("src", IMG_MONKEY_1);
          break;
        case IMG_MONKEY_1:
          imgSrc1.setAttribute("src", IMG_PANDA_1);
          break;
        case IMG_PANDA_1:
          imgSrc1.setAttribute("src", IMG_CAT_1);
          break;
      }
      break;
    case 2:
      switch (imgSrc2.getAttribute("src")) {
        case IMG_CAT_2:
          imgSrc2.setAttribute("src", IMG_MONKEY_2);
          break;
        case IMG_MONKEY_2:
          imgSrc2.setAttribute("src", IMG_PANDA_2);
          break;
        case IMG_PANDA_2:
          imgSrc2.setAttribute("src", IMG_CAT_2);
          break;
      }
      break;
    case 3:
      switch (imgSrc3.getAttribute("src")) {
        case IMG_CAT_3:
          imgSrc3.setAttribute("src", IMG_MONKEY_3);
          break;
        case IMG_MONKEY_3:
          imgSrc3.setAttribute("src", IMG_PANDA_3);
          break;
        case IMG_PANDA_3:
          imgSrc3.setAttribute("src", IMG_CAT_3);
          break;
      }
      break;
    case 4:
      switch (imgSrc4.getAttribute("src")) {
        case IMG_CAT_4:
          imgSrc4.setAttribute("src", IMG_MONKEY_4);
          break;
        case IMG_MONKEY_4:
          imgSrc4.setAttribute("src", IMG_PANDA_4);
          break;
        case IMG_PANDA_4:
          imgSrc4.setAttribute("src", IMG_CAT_4);
          break;
      }
      break;
    case 5:
      switch (imgSrc5.getAttribute("src")) {
        case IMG_CAT_5:
          imgSrc5.setAttribute("src", IMG_MONKEY_5);
          break;
        case IMG_MONKEY_5:
          imgSrc5.setAttribute("src", IMG_PANDA_5);
          break;
        case IMG_PANDA_5:
          imgSrc5.setAttribute("src", IMG_CAT_5);
          break;
      }
      break;
  }
  checkWin();
}

function checkWin() {
  if (
    imgSrc1.getAttribute("src") === IMG_CAT_1 &&
    imgSrc2.getAttribute("src") === IMG_CAT_2 &&
    imgSrc3.getAttribute("src") === IMG_CAT_3 &&
    imgSrc4.getAttribute("src") === IMG_CAT_4 &&
    imgSrc5.getAttribute("src") === IMG_CAT_5
  ) {
    handleWinner();
  } else if (
    imgSrc1.getAttribute("src") === IMG_MONKEY_1 &&
    imgSrc2.getAttribute("src") === IMG_MONKEY_2 &&
    imgSrc3.getAttribute("src") === IMG_MONKEY_3 &&
    imgSrc4.getAttribute("src") === IMG_MONKEY_4 &&
    imgSrc5.getAttribute("src") === IMG_MONKEY_5
  ) {
    handleWinner();
  } else if (
    imgSrc1.getAttribute("src") === IMG_PANDA_1 &&
    imgSrc2.getAttribute("src") === IMG_PANDA_2 &&
    imgSrc3.getAttribute("src") === IMG_PANDA_3 &&
    imgSrc4.getAttribute("src") === IMG_PANDA_4 &&
    imgSrc5.getAttribute("src") === IMG_PANDA_5
  ) {
    handleWinner();
  }
}

function replay() {
  window.location.reload();
}

function removeEventImg() {
  imgSrc1.onclick = null;
  imgSrc2.onclick = null;
  imgSrc3.onclick = null;
  imgSrc4.onclick = null;
  imgSrc5.onclick = null;
}

function handleWinner() {
  document.getElementById("messageWin").innerHTML = MESSAGE_WIN;
  document.getElementById("replay").removeAttribute("hidden");
  removeEventImg();
}
