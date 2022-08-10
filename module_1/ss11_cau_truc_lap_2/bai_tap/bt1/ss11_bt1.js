function bangCuuChuong() {
  let table = "<table width='100%' border='1px solid black' height='500px'>";
  for (let i = 1; i < 10; i++) {
    table += "<tr>";
    for (let j = 2; j < 10; j++) {
      table += "<td>" + j + "x" + i + "=" + i * j + "</td>";
    };
    table += "</tr>";
  }
  table += "</table>";
  document.write(table);
}

bangCuuChuong();
