CREATE SCHEMA IF NOT EXISTS `wallet` DEFAULT CHARACTER SET utf8;
USE `wallet` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `expense`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `expense` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `user_id` BIGINT(20) NOT NULL ,
  `category_id` BIGINT(20) NOT NULL ,
  `title` VARCHAR(255) NOT NULL ,
  `description` VARCHAR(255) NULL DEFAULT NULL ,
  `amount` BIGINT(20) NOT NULL ,
  `date` DATETIME NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_expense_user`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` ),
  CONSTRAINT `fk_expense_category`
    FOREIGN KEY (`category_id` )
    REFERENCES `category` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 33
DEFAULT CHARACTER SET = utf8;