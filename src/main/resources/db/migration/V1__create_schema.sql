SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
-- -----------------------------------------------------
-- Schema easymensa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `easymensa` DEFAULT CHARACTER SET utf8mb4 ;
USE `easymensa` ;
-- -----------------------------------------------------
-- Table `easymensa`.`allergen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easymensa`.`allergen` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `short_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `easymensa`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easymensa`.`flyway_schema_history` (
  `installed_rank` INT(11) NOT NULL,
  `version` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `script` VARCHAR(1000) NOT NULL,
  `checksum` INT(11) NULL DEFAULT NULL,
  `installed_by` VARCHAR(100) NOT NULL,
  `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `execution_time` INT(11) NOT NULL,
  `success` TINYINT(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  INDEX `flyway_schema_history_s_idx` (`success` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `easymensa`.`food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easymensa`.`food` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `image` LONGTEXT NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `type` ENUM('VEGETARIAN', 'VEGAN', 'MEAT') NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `easymensa`.`food_allergen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easymensa`.`food_allergen` (
  `allergen_id` BIGINT(20) NOT NULL,
  `food_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`allergen_id`, `food_id`),
  INDEX `FKdgaup80cr2nd2xf4utot7p5yd` (`food_id` ASC) VISIBLE,
  CONSTRAINT `FKdgaup80cr2nd2xf4utot7p5yd`
    FOREIGN KEY (`food_id`)
    REFERENCES `easymensa`.`allergen` (`id`),
  CONSTRAINT `FKfc81usvshhbwo3fgg6kqfmn9p`
    FOREIGN KEY (`allergen_id`)
    REFERENCES `easymensa`.`food` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `easymensa`.`menu_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easymensa`.`menu_plan` (
  `date` DATE NOT NULL,
  PRIMARY KEY (`date`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `easymensa`.`menuplan_food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easymensa`.`menuplan_food` (
  `menuplan_id` DATE NOT NULL,
  `food_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`menuplan_id`, `food_id`),
  INDEX `FKdm6ywre4eb0bddpbbb5ntqen8` (`food_id` ASC) VISIBLE,
  CONSTRAINT `FKdm6ywre4eb0bddpbbb5ntqen8`
    FOREIGN KEY (`food_id`)
    REFERENCES `easymensa`.`food` (`id`),
  CONSTRAINT `FKe7370vejhcbwva3iw4pupbrxa`
    FOREIGN KEY (`menuplan_id`)
    REFERENCES `easymensa`.`menu_plan` (`date`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
