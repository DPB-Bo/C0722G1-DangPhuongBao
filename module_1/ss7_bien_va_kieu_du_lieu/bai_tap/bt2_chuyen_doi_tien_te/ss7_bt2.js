
function transfer() {
amount = document.getElementById("amount_lb").value;
fcurrency = document.getElementById("fcurrency_lb").value;
tcurrency = document.getElementById("tcurrency_lb").value;
  if (amount < 0) {
    alert("Hãy nhập giá trị chính xác");
  } else {
    let value_transfered;
    if (fcurrency == "VND") {
      if (tcurrency == "VND") {
        value_transfered = amount*1 + " VND";
      } else {
        if (tcurrency == "USD") {
          value_transfered = ((amount * 1) / 23000).toFixed(4) + " USD";
        } else {
          value_transfered = ((amount * 1) / 23.932).toFixed(4) + " EURO";
        }
      }
    } else {
      if (fcurrency == "USD") {
        if (tcurrency == "VND") {
          value_transfered = amount * 23000 + " VND";
        } else {
          if (tcurrency == "USD") {
            value_transfered = amount * 1 + " USD";
          } else {
            value_transfered =( amount * 0.98).toFixed(4) + " EURO";
          }
        }
      } else {
        if (tcurrency == "VND") {
          value_transfered = amount * 23000 + " VND";
        } else {
          if (tcurrency == "USD") {
            value_transfered = (amount * 1.02).toFixed(4) + " USD";
          } else {
            value_transfered = amount * 1 + " EURO";
          }
        }
      }
    };
    document.getElementById("display_value_transfered").value =
      value_transfered;
  };
}
