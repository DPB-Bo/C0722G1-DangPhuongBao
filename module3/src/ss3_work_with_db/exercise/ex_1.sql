USE quanlysinhvien;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT 
    *
FROM
    class
WHERE
    student_name REGEXP ('^[hH]');

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
SELECT 
    *
FROM
    class
WHERE
    MONTH(start_date) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5. 
SELECT 
    *
FROM
    subject
WHERE
    credit BETWEEN 3 AND 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
UPDATE student 
SET 
    class_id = 2
WHERE
    name = 'hung';
    
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT student.student_name, sub.sub_name, mark.mark
FROM student
JOIN sub ON student.sub_id = sub.sub_id
JOIN mark ON student.mark = mark.mark
ORDER BY mark DESC, student_name;