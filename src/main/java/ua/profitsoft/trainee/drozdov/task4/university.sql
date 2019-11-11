-- -----------------------------------------------------
-- Table `course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teacher` (
    `id` INT NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `course` (
    `id` INT NOT NULL,
    `course_title` VARCHAR(45) NOT NULL,
    `id_teacher` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `course_title_UNIQUE` (`course_title` ASC) VISIBLE,
    INDEX `fk_teacher_idx` (`id_teacher` ASC) VISIBLE,
    CONSTRAINT `fk_teacher`
    FOREIGN KEY (`id_teacher`)
    REFERENCES `teacher` (`id`));


-- -----------------------------------------------------
-- Table `group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `group` (
    `id` INT NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student` (
    `id` INT NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `id_group` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_group_idx` (`id_group` ASC) VISIBLE,
    CONSTRAINT `fk_group`
    FOREIGN KEY (`id_group`)
    REFERENCES `group` (`id`));


-- -----------------------------------------------------
-- Table `marks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marks` (
    `mark` INT NOT NULL,
    `id_student` INT NOT NULL,
    `id_course` INT NOT NULL,
    INDEX `fk_student_idx` (`id_student` ASC) VISIBLE,
    INDEX `course_fk_idx` (`id_course` ASC) VISIBLE,
    CONSTRAINT `fk_student`
    FOREIGN KEY (`id_student`)
    REFERENCES `student` (`id`),
    CONSTRAINT `course_fk`
    FOREIGN KEY (`id_course`)
    REFERENCES `course` (`id`));
