
-- --------------------------------------------------------------
-- Написать запрос для выборки всех преподавателей на курсах которых учатся больше 2000 студентов.
-- --------------------------------------------------------------
SELECT t.first_name, t.last_name
FROM teacher t
    JOIN course c ON  c.id_teacher = t.id
        JOIN marks m ON m.id_course = c.id
GROUP BY t.id
HAVING COUNT(m.id_student)>2000;


-- --------------------------------------------------------------
-- Написать запрос для выборки студентов у которых по курсу 'Programming' оценка > 4. Отсортировать их по имени
-- --------------------------------------------------------------
SELECT s.id,  s.first_name, s.last_name
FROM student s
    JOIN marks m ON s.id = m.id_student
        JOIN course c on m.id_course = c.id
WHERE m.mark > 4 AND course_title LIKE 'Programming'
ORDER BY s.first_name;


-- --------------------------------------------------------------
-- Написать Запрос,который выведет список отличников,сгруппированных по группам
-- --------------------------------------------------------------
SELECT DISTINCT s.id, s.first_name, s.last_name, g.name
FROM student s
    JOIN marks m on s.id = m.id_student
    JOIN `group` g on s.id_group = g.id
WHERE s.id NOT IN (SELECT m.id_student
    WHERE m.mark < 5)
ORDER BY g.name;