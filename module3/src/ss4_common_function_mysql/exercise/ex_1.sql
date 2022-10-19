USE quanlysinhvien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT *, MAX(credit)
FROM _subject
GROUP BY sub_name;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT * , MAX(mark.mark) AS max_mark
FROM _subject s
JOIN mark ON mark.sub_id = s.sub_id 
HAVING MAX(MARK);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT *, AVG(mark.mark) AS avg_mark
FROM student s
JOIN mark ON mark.student_id = s.student_id
GROUP BY s.student_id
ORDER BY avg_mark DESC