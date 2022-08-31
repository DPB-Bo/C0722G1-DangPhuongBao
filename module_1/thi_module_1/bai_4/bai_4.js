class BenhNhan {
    constructor(soThuTu, hoVaTen, tuoi, diaChi, soDienThoai) {
        this.soThuTu = soThuTu;
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
    getSoThuTu() {
        return this.soThuTu;
    }
    getHoVaTen() {
        return this.hoVaTen;
    }
    getTuoi() {
        return this.tuoi;
    }
    getDiaChi() {
        return this.diaChi;
    }
    getSoDienThoai() {
        return this.soDienThoai;
    }
    setSoThuTu(soThuTu) {
        this.soThuTu = soThuTu;
    }
    setHoVaTen(hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
    setTuoi(tuoi) {
        this.tuoi = tuoi;
    }
    setDiaChi(diaChi) {
        this.diaChi = diaChi;
    }
    setSoDienThoai(soSoDienThoai) {
        this.soDienThoai = soSoDienThoai;
    }
}

let benhNhanId1 = new BenhNhan(1, 'Nguyễn Lê Hoàng Oanh', 20, 'Quảng Nam', '0923434564');
let benhNhanId5 = new BenhNhan(5, 'Anh', 20, 'Quảng Nam', '0923434564');
let benhNhanId2 = new BenhNhan(2, 'Nguyễn Trần Cảnh', 30, 'Quảng Nam', '0943246324');
let benhNhanId3 = new BenhNhan(3, 'Hoàng Thanh Hùng', 15, 'Quảng Nam', '0123451235');
let benhNhanId4 = new BenhNhan(4, 'Trần Lệ Quyên', 19, 'Quảng Nam', '0923093748');
let mangDanhSachBenhNhan = [benhNhanId2, benhNhanId1, benhNhanId4, benhNhanId3, benhNhanId5];
let hienThiDanhSach = document.getElementById('hienThiDanhSach');
let xepSTTTangDan = false;
let xepTuoiTangDan = true;

mangDanhSachBenhNhan.sort(function (a, b) {
    if (a.getHoVaTen() > b.getHoVaTen()) return 1;
    if (a.getHoVaTen() < b.getHoVaTen()) return -1;
    return 0;
});
veBangDanhSach(mangDanhSachBenhNhan);

function veBangDanhSach(mangDanhSachBenhNhan) {
    let bang = '<table id="displayTable" style="margin:auto; width: 50%;padding: 10px;border-collapse: collapse" border="1px solid black">' +
        '<caption><h1>Danh sách bệnh nhân</h1></caption>' +
        '<tr>' +
        '<th onclick="xepTheoSTT()">STT</th>' +
        '<th>Họ và tên</th>' +
        '<th onclick="xepTheoTuoi()">Tuổi</th>' +
        '<th>Địa chỉ</th>' +
        '<th>Số điện thoại</th>' +
        '</tr>';
    for (let i = 0; i < mangDanhSachBenhNhan.length; i++) {
        bang += '<tr>';
        bang += '<td >' + mangDanhSachBenhNhan[i].getSoThuTu() + '</td>' +
            '<td>' + mangDanhSachBenhNhan[i].getHoVaTen() + '</td>' +
            '<td>' + mangDanhSachBenhNhan[i].getTuoi() + '</td>' +
            '<td>' + mangDanhSachBenhNhan[i].getDiaChi() + '</td>' +
            '<td>' + mangDanhSachBenhNhan[i].getSoDienThoai() + '</td>';
        bang += '</tr>';
    }
    bang += '</table>';
    hienThiDanhSach.innerHTML = bang;
}

function xepTheoSTT() {
    if (xepSTTTangDan) {
        mangDanhSachBenhNhan.sort(function (a, b) {
            return a.getSoThuTu() - b.getSoThuTu();
        })
        veBangDanhSach(mangDanhSachBenhNhan);
        xepSTTTangDan = !xepSTTTangDan;
    } else {
        mangDanhSachBenhNhan.sort(function (a, b) {
            return b.getSoThuTu() - a.getSoThuTu();
        })
        veBangDanhSach(mangDanhSachBenhNhan);
        xepSTTTangDan = !xepSTTTangDan;
    }
}

function xepTheoTuoi() {
    if (xepTuoiTangDan) {
        mangDanhSachBenhNhan.sort(function (a, b) {
            return a.getTuoi() - b.getTuoi();
        })
        veBangDanhSach(mangDanhSachBenhNhan);
        xepTuoiTangDan = !xepTuoiTangDan;
    } else {
        mangDanhSachBenhNhan.sort(function (a, b) {
            return b.getTuoi() - a.getTuoi();
        })
        veBangDanhSach(mangDanhSachBenhNhan);
        xepTuoiTangDan = !xepTuoiTangDan;
    }
}

