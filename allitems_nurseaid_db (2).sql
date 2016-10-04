-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 26, 2016 at 08:40 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `allitems_nurseaid_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE IF NOT EXISTS `tbl_admin` (
`id` int(11) NOT NULL,
  `full_name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `last_login_timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id`, `full_name`, `username`, `password`, `email`, `last_login_timestamp`) VALUES
(124, 'Nimesh L Shrestha', 'nimesh124', 'nimesh124', 'nuru.freelancer@gmail.com', '2016-09-08 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_attachment`
--

CREATE TABLE IF NOT EXISTS `tbl_attachment` (
`id` int(11) NOT NULL,
  `title` varchar(40) NOT NULL,
  `detail` text NOT NULL,
  `is_required` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0=No, 1=Yes',
  `for_type` tinyint(4) NOT NULL COMMENT '1=Employee, 2=Employer'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_attachment`
--

INSERT INTO `tbl_attachment` (`id`, `title`, `detail`, `is_required`, `for_type`) VALUES
(1, 'Driver''s License', '<p>Some text</p>', 1, 2),
(2, 'Police Check', '<p>Police Check</p>', 1, 1),
(3, 'Visa Status', '<p>Visa Status</p>', 1, 1),
(4, '100 Points ID', '<p>100 Points ID</p>', 1, 1),
(5, 'Signed Contract', '<p>Signed Contract</p>', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cms`
--

CREATE TABLE IF NOT EXISTS `tbl_cms` (
`id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `last_modified_on` datetime NOT NULL,
  `created_by` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cms`
--

INSERT INTO `tbl_cms` (`id`, `title`, `content`, `last_modified_on`, `created_by`) VALUES
(4, 'About Us', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum&nbsp;Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>', '2016-09-18 20:30:06', 124),
(5, 'Terms and Conditions', '<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?&nbsp;</p>\r\n<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</p>\r\n<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</p>', '2016-09-19 07:05:22', 124),
(6, 'Privacy Policy', '<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.</p>\r\n<p>&nbsp;</p>\r\n<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.</p>', '2016-09-21 19:58:21', 124),
(7, 'Employer Registration Page', '<p>Please download registration form and contract. Fill it and sign on both forms and attach it to its appropriate place. Alternatively, you can send all your documents to <a href="mailto:registration@nurseaid.com.au">registration@nurseaid.com.au</a> <br /><br /> <span class="download-label">Application Form</span><a class="btn btn-sm btn-info" href="#">Download</a><br /> <span class="download-label">Contract</span><a class="btn btn-sm btn-info" href="#">Download</a></p>', '2016-09-22 13:56:40', 124),
(8, 'Employer Registration Successful', '<p>Thank you for signing up.</p>\r\n<p>Account has been created. Please wait till admin activates your account !!!</p>', '2016-09-22 17:46:47', 124),
(9, 'Employee Registration Successful', '<p>Thank you for signing up.</p>\r\n<p>Account has been created. Please wait till admin activates your account !!!</p>', '2016-09-23 12:29:38', 124),
(10, 'Employee Registration Page', '<p>Please download registration form and contract. Fill it and sign on both forms and attach it to its appropriate place. Alternatively, you can send all your documents to <a href="mailto:registration@nurseaid.com.au">registration@nurseaid.com.au</a> <br /><br /> <span class="download-label">Application Form</span><a class="btn btn-sm btn-info" href="#">Download</a><br /> <span class="download-label">Contract</span><a class="btn btn-sm btn-info" href="#">Download</a></p>', '2016-09-23 12:30:10', 124),
(11, 'NurseAid.com', '<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>', '2016-09-23 13:07:33', 124);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_country`
--

CREATE TABLE IF NOT EXISTS `tbl_country` (
`id` int(11) NOT NULL,
  `title` varchar(25) NOT NULL,
  `nationality` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_country`
--

INSERT INTO `tbl_country` (`id`, `title`, `nationality`) VALUES
(1, 'Nepal', 'Nepalese'),
(3, 'Abkhazia', 'Abkhazian'),
(4, 'Afghanistan', 'Afghan'),
(5, 'Albania', 'Albanian'),
(6, 'Algeria', 'Algerian'),
(7, 'American samoa', 'American Samoan'),
(8, 'Andorra', 'Andorran'),
(9, 'Angola', 'Angolan'),
(10, 'Anguilla', 'Anguillan'),
(11, 'Antigua and barbuda', 'Antiguan/Barbudan'),
(12, 'Argentina', 'Argentinean'),
(13, 'Armenia', 'Armenian'),
(14, 'Aruba', 'Aruban'),
(15, 'Australia', 'Australian'),
(16, 'Austria', 'Austrian'),
(17, 'Azerbaijan', 'Azerbaijani'),
(18, 'Bahamas', 'Bahamian'),
(19, 'Bahrain', 'Bahraini'),
(20, 'Bangladesh', 'Bangladeshi'),
(21, 'Barbados', 'Barbadian'),
(22, 'Belarus', 'Belarusian'),
(23, 'Belgium', 'Belgian'),
(24, 'Belize', 'Belizean'),
(25, 'Benin', 'Beninese'),
(26, 'Bermuda', 'Bermudian'),
(27, 'Bhutan', 'Bhutanese'),
(28, 'Bolivia', 'Bolivian'),
(29, 'Bosnia and herzegovina', 'Bosnian/Herzegovinia'),
(30, 'Botswana', 'Motswana'),
(31, 'Brazil', 'Brazilian'),
(32, 'British virgin islands', 'British Virgin Islan'),
(33, 'Brunei', 'Bruneian'),
(34, 'Bulgaria', 'Bulgarian'),
(35, 'Burkina fasoa', 'Burkinabè'),
(36, 'Burmab', 'Burmese'),
(37, 'Burundi', 'Burundian'),
(38, 'Cambodia', 'Cambodian'),
(39, 'Cameroon', 'Cameroonian'),
(40, 'Canada', 'Canadian'),
(41, 'Cape verde', 'Cape Verdean'),
(42, 'Cayman islands', 'Caymanian'),
(43, 'Central african republic', 'Central African'),
(44, 'Chad', 'Chadian'),
(45, 'Chile', 'Chilean'),
(46, 'Christmas island', 'Christmas Island'),
(47, 'Cocos (keeling) islands', 'Cocos Island'),
(48, 'Colombia', 'Colombian'),
(49, 'Comoros', 'Comorian'),
(50, 'Cook islands', 'Cook Island'),
(51, 'Costa rica', 'Costa Rican'),
(52, 'Croatia', 'Croatian'),
(53, 'Cuba', 'Cuban'),
(54, 'Cyprus', 'Cypriot'),
(55, 'Czech republic', 'Czech'),
(56, 'Dem. republic of the cong', 'Congolese'),
(57, 'Denmark', 'Danish'),
(58, 'Djibouti', 'Djiboutian'),
(59, 'Dominica', 'Dominicand'),
(60, 'Dominican republic', 'Dominicane'),
(61, 'East timor', 'Timorese'),
(62, 'Ecuador', 'Ecuadorian'),
(63, 'Egypt', 'Egyptian'),
(64, 'El salvador', 'Salvadoran'),
(65, 'England', 'English'),
(66, 'Equatorial guinea', 'Equatorial Guinean'),
(67, 'Eritrea', 'Eritrean'),
(68, 'Estonia', 'Estonian'),
(69, 'Ethiopia', 'Ethiopian'),
(70, 'Falkland islands', 'Falkland Island'),
(71, 'Faroe islands', 'Faroese'),
(72, 'Fiji', 'Fijian'),
(73, 'Finland', 'Finnish'),
(74, 'France', 'French'),
(75, 'French guiana', 'French Guianese'),
(76, 'French polynesia', 'French Polynesian'),
(77, 'Gabon', 'Gabonese'),
(78, 'Gambia', 'Gambian'),
(79, 'Georgia', 'Georgian'),
(80, 'Germany', 'German'),
(81, 'Ghana', 'Ghanaian'),
(82, 'Gibraltar', 'Gibraltar'),
(83, 'Great britain', 'British'),
(84, 'Greece', 'Greek'),
(85, 'Greenland', 'Greenlandic'),
(86, 'Grenada', 'Grenadian'),
(87, 'Guadeloupe', 'Guadeloupe'),
(88, 'Guam', 'Guamanian'),
(89, 'Guatemala', 'Guatemalan'),
(90, 'Guinea', 'Guinean'),
(91, 'Guinea-bissau', 'Guinean'),
(92, 'Guyana', 'Guyanese'),
(93, 'Haiti', 'Haitian'),
(94, 'Honduras', 'Honduran'),
(95, 'Hong kong', 'Hongkongese'),
(96, 'Hungary', 'Hungarian'),
(97, 'Iceland', 'Icelandic'),
(98, 'India', 'Indian'),
(99, 'Indonesia', 'Indonesian'),
(100, 'Iran', 'Iranian'),
(101, 'Iraq', 'Iraqi'),
(102, 'Ireland', 'Irish'),
(103, 'Isle of man', 'Manx'),
(104, 'Israel', 'Israeli'),
(105, 'Italy', 'Italian'),
(106, 'Jamaica', 'Jamaican'),
(107, 'Japan', 'Japanese'),
(108, 'Jordan', 'Jordanian'),
(109, 'Kazakhstan', 'Kazakh'),
(110, 'Kenya', 'Kenyan'),
(111, 'Kiribati', 'I-Kiribati'),
(112, 'Kosovo', 'Kosovar'),
(113, 'Kuwait', 'Kuwaiti'),
(114, 'Kyrgyzstan', 'Kyrgyzstani'),
(115, 'Laos', 'Laotian'),
(116, 'Latvia', 'Latvian'),
(117, 'Lebanon', 'Lebanese'),
(118, 'Lesotho', 'Basotho'),
(119, 'Liberia', 'Liberian'),
(120, 'Libya', 'Libyan'),
(121, 'Liechtenstein', 'Liechtenstein'),
(122, 'Lithuania', 'Lithuanian'),
(123, 'Luxembourg', 'Luxembourgish'),
(124, 'Macau', 'Macanese'),
(125, 'Madagascar', 'Malagasy'),
(126, 'Malawi', 'Malawian'),
(127, 'Malaysia', 'Malaysian'),
(128, 'Maldives', 'Maldivian'),
(129, 'Mali', 'Malian'),
(130, 'Malta', 'Maltese'),
(131, 'Marshall islands', 'Marshallese'),
(132, 'Martinique', 'Martiniquais'),
(133, 'Mauritania', 'Mauritanian'),
(134, 'Mauritius', 'Mauritian'),
(135, 'Mayotte', 'Mahoran'),
(136, 'Mexico', 'Mexican'),
(137, 'Micronesia, federated sta', 'Micronesian'),
(138, 'Moldova', 'Moldovan'),
(139, 'Monaco', 'Monégasque, Monacan'),
(140, 'Mongolia', 'Mongolian'),
(141, 'Montenegro', 'Montenegrin'),
(142, 'Montserrat', 'Montserratian'),
(143, 'Morocco', 'Moroccan'),
(144, 'Mozambique', 'Mozambican'),
(145, 'Namibia', 'Namibian'),
(146, 'Nauru', 'Nauruan'),
(147, 'Nepal', 'Nepali'),
(148, 'Netherlands', 'Dutch'),
(149, 'New caledonia', 'New Caledonian'),
(150, 'New zealand', 'New Zealand'),
(151, 'Nicaragua', 'Nicaraguan'),
(152, 'Niger', 'Nigerien'),
(153, 'Nigeria', 'Nigerian'),
(154, 'Niue', 'Niuean'),
(155, 'North korea', 'North Korean'),
(156, 'Northern ireland', 'Northern Irish'),
(157, 'Northern marianas', 'Northern Marianan'),
(158, 'Norway', 'Norwegian'),
(159, 'Oman', 'Omani'),
(160, 'Pakistan', 'Pakistani'),
(161, 'Palau', 'Palauan'),
(162, 'Palestine', 'Palestinian'),
(163, 'Panama', 'Panamanian'),
(164, 'Papua new guinea', 'Papua New Guinean'),
(165, 'Paraguay', 'Paraguayan'),
(166, 'Peru', 'Peruvian'),
(167, 'Philippines', 'Filipino'),
(168, 'Pitcairn island', 'Pitcairn Island'),
(169, 'Poland', 'Polish'),
(170, 'Portugal', 'Portuguese'),
(171, 'Puerto rico', 'Puerto Rican'),
(172, 'Qatar', 'Qatari'),
(173, 'Republic of china', 'Chinese'),
(174, 'Republic of ireland', 'Irish'),
(175, 'Republic of macedonia', 'Macedonian'),
(176, 'Republic of the congo', 'Congolese'),
(177, 'Romania', 'Romanian'),
(178, 'Russia', 'Russian'),
(179, 'Rwanda', 'Rwandan'),
(180, 'Réunion', 'Réunionese'),
(181, 'Saint-pierre and miquelon', 'Saint-Pierrais/Mique'),
(182, 'Samoa', 'Samoan'),
(183, 'San marino', 'Sammarinese'),
(184, 'Saudi arabia', 'Saudi Arabian'),
(185, 'Scotland', 'Scottish'),
(186, 'Senegal', 'Senegalese'),
(187, 'Serbia', 'Serbian'),
(188, 'Seychelles', 'Seychellois'),
(189, 'Sierra leone', 'Sierra Leonean'),
(190, 'Singapore', 'Singapore'),
(191, 'Slovakia', 'Slovak'),
(192, 'Slovenia', 'Slovenian'),
(193, 'Solomon islands', 'Solomon Island'),
(194, 'Somalia', 'Somalian'),
(195, 'South africa', 'South African'),
(196, 'South korea', 'South Korean'),
(197, 'South ossetia', 'South Ossetian'),
(198, 'South sudan', 'South Sudanese'),
(199, 'Spain', 'Spanish'),
(200, 'Sri lanka', 'Sri Lankan'),
(201, 'St. helena', 'St. Helenian'),
(202, 'St. kitts and nevis', 'Kittitian/Vincentian'),
(203, 'St. lucia', 'St. Lucian'),
(204, 'St. vincent and the grena', 'St. Vincentian'),
(205, 'Sudan', 'Sudanese'),
(206, 'Surinam', 'Surinamese'),
(207, 'Swaziland', 'Swazi'),
(208, 'Sweden', 'Swedish'),
(209, 'Switzerland', 'Swiss'),
(210, 'Syria', 'Syrian'),
(211, 'São tomé and príncipe', 'São Toméan'),
(212, 'Taiwan', 'Taiwanese'),
(213, 'Tajikistan', 'Tajikistani'),
(214, 'Tanzania', 'Tanzanian'),
(215, 'Thailand', 'Thai'),
(216, 'Togo', 'Togolese'),
(217, 'Tonga', 'Tongan'),
(218, 'Trinidad and tobago', 'Trinidadian'),
(219, 'Tunisia', 'Tunisian'),
(220, 'Turkey', 'Turkish'),
(221, 'Turkmenistan', 'Turkmen'),
(222, 'Turks and caicos islands', 'none'),
(223, 'Tuvalu', 'Tuvaluan'),
(224, 'Uganda', 'Ugandan'),
(225, 'Ukraine', 'Ukrainian'),
(226, 'United arab emirates', 'Emirati'),
(227, 'United kingdom', 'British'),
(228, 'United states', 'American'),
(229, 'Uruguay', 'Uruguayan'),
(230, 'Uzbekistan', 'Uzbekistani'),
(231, 'Vanuatu', 'Ni-Vanuatu'),
(232, 'Venezuela', 'Venezuelan'),
(233, 'Vietnam', 'Vietnamese'),
(234, 'Virgin islands', 'Virgin Island'),
(235, 'Wales', 'Welsh'),
(236, 'Wallis and futuna', 'Wallisian/Futunan'),
(237, 'Western sahara', 'Sahrawian'),
(238, 'Yemen', 'Yemeni'),
(239, 'Zambia', 'Zambian'),
(240, 'Zimbabwe', 'Zimbabwean');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE IF NOT EXISTS `tbl_employee` (
`id` int(11) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mobile` varchar(30) NOT NULL,
  `social_media_params` text,
  `password_key` varchar(50) DEFAULT NULL,
  `photo_file` varchar(40) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL COMMENT '1=Male, 2=Female',
  `max_hours_per_fortnight` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `home_phone` varchar(30) DEFAULT NULL,
  `work_phone` varchar(30) DEFAULT NULL,
  `tbl_entity_abstract_id` int(11) NOT NULL,
  `tbl_nationality_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`id`, `first_name`, `last_name`, `email`, `mobile`, `social_media_params`, `password_key`, `photo_file`, `gender`, `max_hours_per_fortnight`, `dob`, `start_date`, `home_phone`, `work_phone`, `tbl_entity_abstract_id`, `tbl_nationality_id`) VALUES
(1, 'Nimesh', 'Shrestha', 'nimesh.124@gmail.com', '9999', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL),
(2, 'Manish', 'Tandukar', 'manish@gmail.com', '8888888', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL),
(3, 'Kamal', 'Kafle', 'kamal@gmail.com', '1111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 22, NULL),
(4, 'Ajay', 'Sharma', 'ajay@gmail.com', '888888', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 26, NULL),
(5, 'Nivaj', 'Shakya', 'nivaj@gmail.com', '77777777', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 27, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employer`
--

CREATE TABLE IF NOT EXISTS `tbl_employer` (
`id` int(11) NOT NULL,
  `company_name` varchar(100) NOT NULL,
  `contact_person` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `company_number` varchar(30) NOT NULL,
  `contact_person_position` varchar(40) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `work_phone` varchar(20) DEFAULT NULL,
  `geocoded_latitude` varchar(15) DEFAULT NULL,
  `geocoded_longitude` varchar(15) DEFAULT NULL,
  `tbl_entity_abstract_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_employer`
--

INSERT INTO `tbl_employer` (`id`, `company_name`, `contact_person`, `email`, `company_number`, `contact_person_position`, `mobile`, `work_phone`, `geocoded_latitude`, `geocoded_longitude`, `tbl_entity_abstract_id`) VALUES
(5, 'Jindalee Nursing Home', 'Ram Kumar Shrestha', 'ram@jindalee.com', '555555', NULL, NULL, NULL, '', '', 15),
(6, 'Advanced College of Engineering and Mnagement', 'ShreeRam Neupane', 'shree@gmail.com', '99833773', NULL, NULL, NULL, '', '', 25);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_entity_abstract`
--

CREATE TABLE IF NOT EXISTS `tbl_entity_abstract` (
`id` int(11) NOT NULL,
  `address_1` varchar(45) DEFAULT NULL,
  `address_2` varchar(45) DEFAULT NULL,
  `suburb` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0=inactive, 1=active',
  `created_date` datetime DEFAULT NULL,
  `entity_code` varchar(15) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `tbl_country_id` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_entity_abstract`
--

INSERT INTO `tbl_entity_abstract` (`id`, `address_1`, `address_2`, `suburb`, `state`, `postcode`, `status`, `created_date`, `entity_code`, `username`, `password`, `tbl_country_id`) VALUES
(15, NULL, NULL, NULL, NULL, NULL, 0, '2016-09-08 00:00:00', 'ER-IIUWER', 'er', 'er', NULL),
(20, 'ktm', NULL, NULL, NULL, NULL, 0, '2016-09-24 00:00:00', 'EE-RTYYTS', 'ee', 'ee', NULL),
(21, 'chakupat', NULL, NULL, NULL, NULL, 0, '2016-09-25 00:00:00', 'EE-YAASDS', 'manish', 'manish', NULL),
(22, 'Chabahil', NULL, NULL, NULL, NULL, 0, NULL, 'EE-UOALVX', 'kamal111', 'kamal111', NULL),
(23, 'kupondole', NULL, NULL, NULL, NULL, 0, NULL, 'ER-ZLILYW', 'shree111', 'shree111', NULL),
(24, 'kupondole', NULL, NULL, NULL, NULL, 0, NULL, 'ER-MRVOTD', 'shree111', 'shree111', NULL),
(25, 'kupondole', NULL, NULL, NULL, NULL, 0, NULL, 'ER-GFGTDP', 'shree111', 'shree111', NULL),
(26, 'kupondole', NULL, NULL, NULL, NULL, 0, NULL, 'EE-KSBOBG', 'ajay111', 'ajay111', NULL),
(27, 'kumaripati', NULL, NULL, NULL, NULL, 0, NULL, 'EE-CLTOZN', 'nivaj111', 'nivaj111', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_entity_attachment`
--

CREATE TABLE IF NOT EXISTS `tbl_entity_attachment` (
`id` int(11) NOT NULL,
  `expiry_date` date NOT NULL,
  `references` text NOT NULL,
  `comments` text NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `last_modified_by` int(11) NOT NULL,
  `attachment_file` varchar(45) DEFAULT NULL,
  `entity_type` tinyint(4) NOT NULL COMMENT '1=Employee, 2=Employer',
  `email_status` tinyint(4) DEFAULT NULL COMMENT '1=Sent',
  `tbl_attachment_id` int(11) NOT NULL,
  `tbl_entity_abstract_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='or employer-employee ability';

-- --------------------------------------------------------

--
-- Table structure for table `tbl_job`
--

CREATE TABLE IF NOT EXISTS `tbl_job` (
`id` int(11) NOT NULL,
  `reference_number` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `shift_from` varchar(15) NOT NULL,
  `shift_to` varchar(15) NOT NULL,
  `job_date` date NOT NULL,
  `tbl_employer_id` int(11) NOT NULL,
  `position_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_job`
--

INSERT INTO `tbl_job` (`id`, `reference_number`, `quantity`, `shift_from`, `shift_to`, `job_date`, `tbl_employer_id`, `position_id`) VALUES
(1, 'JB-ABCDEF', 1, '12:29 PM', '12:29 AM', '2016-09-28', 5, 4),
(2, 'JB-JANIOK', 1, '12:39 PM', '12:41 PM', '2016-09-26', 5, 4),
(3, 'JB-SWNOJR4', 1, '12:40 PM', '12:40 AM', '2016-09-26', 5, 4),
(14, 'JB-SMTKZZ3', 1, '12:43 PM', '12:43 PM', '2016-09-26', 5, 4),
(17, 'JB-CREYGS1', 1, '12:47 PM', '12:47 PM', '2016-09-26', 5, 4),
(18, 'JB-CREYGS2', 1, '12:47 PM', '12:47 PM', '2016-09-26', 5, 4),
(19, 'JB-UXYIFR1', 1, '05:00 PM', '06:00 PM', '2016-09-29', 5, 5),
(20, 'JB-UXYIFR2', 1, '05:00 PM', '06:00 PM', '2016-09-29', 5, 5),
(21, 'JB-UXYIFR3', 1, '05:00 PM', '06:00 PM', '2016-09-29', 5, 5),
(22, 'JB-UXYIFR4', 1, '05:00 PM', '06:00 PM', '2016-09-29', 5, 5),
(23, 'JB-JSFHAX1', 1, '01:00 PM', '05:05 PM', '2016-09-28', 5, 4),
(24, 'JB-JSFHAX2', 1, '01:00 PM', '05:05 PM', '2016-09-28', 5, 4),
(25, 'JB-JSFHAX3', 1, '01:00 PM', '05:05 PM', '2016-09-28', 5, 4),
(26, 'JB-KMMYLZ1', 1, '12:23 AM', '12:23 PM', '2016-09-28', 5, 4),
(27, 'JB-KMMYLZ2', 1, '12:23 AM', '12:23 PM', '2016-09-28', 5, 4),
(28, 'JB-KMMYLZ3', 1, '12:23 AM', '12:23 PM', '2016-09-28', 5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_job_position`
--

CREATE TABLE IF NOT EXISTS `tbl_job_position` (
`id` int(11) NOT NULL,
  `title` varchar(40) NOT NULL,
  `created_by` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_job_position`
--

INSERT INTO `tbl_job_position` (`id`, `title`, `created_by`) VALUES
(4, 'Registered Nurse', 124),
(5, 'Computer Programmer', 124),
(6, 'Accountant', 124),
(7, 'Research Assistant', 124),
(8, 'JAVA Tutor', 124);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_job_status`
--

CREATE TABLE IF NOT EXISTS `tbl_job_status` (
`id` int(11) NOT NULL,
  `job_status` tinyint(4) NOT NULL COMMENT '0=applied, 1=assigned, 2=confirmed, 3=working, 4=completed, 5=paid, 9=declined',
  `tbl_job_id` int(11) NOT NULL,
  `tbl_employee_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_job_status`
--

INSERT INTO `tbl_job_status` (`id`, `job_status`, `tbl_job_id`, `tbl_employee_id`) VALUES
(10, 9, 26, 1),
(11, 9, 26, 1),
(12, 1, 26, 4),
(13, 4, 27, 4),
(14, 9, 27, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_message`
--

CREATE TABLE IF NOT EXISTS `tbl_message` (
`id` int(11) NOT NULL,
  `title` text NOT NULL,
  `subject` varchar(30) NOT NULL,
  `content` text NOT NULL,
  `message_type` tinyint(4) NOT NULL COMMENT '1=email, 2=app-notification'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_message`
--

INSERT INTO `tbl_message` (`id`, `title`, `subject`, `content`, `message_type`) VALUES
(1, 'FORGOT_PASSWORD_EMAIL', 'Reset your Password', '<p>Dear {CUSTOMER_NAME}</p>\r\n<p>&nbsp;</p>\r\n<p>Please click the link below to reset your password</p>\r\n<p>{PASSWORD_RESET_LINK}</p>\r\n<p>&nbsp;</p>\r\n<p>Thank You</p>\r\n<p>{SITE_TITLE}</p>', 1),
(2, 'REGISTRATION_SUCCESSFUL_EMAIL', 'Thank you for registering', '<p>body</p>', 1),
(3, 'DOCUMENT_EXPIRY_EMAIL', 'Your document is expiring', '<p>Your document is expiring</p>', 1),
(4, 'INVOICE_EMAIL', 'Invoice Submitted', '<p>Invoice Submitted</p>', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_password_reset_request`
--

CREATE TABLE IF NOT EXISTS `tbl_password_reset_request` (
`id` int(11) NOT NULL,
  `id_key` varchar(50) NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_password_reset_request`
--

INSERT INTO `tbl_password_reset_request` (`id`, `id_key`, `user_type`, `user_id`) VALUES
(2, '46e79ca2-9aa7-4bf5-abad-57c25acaeaaa', 'admin', 124),
(3, '60fbd358-2fc2-40d6-9cb3-80c0e47f2885', 'admin', 124),
(4, '38229a6a-ab6b-45f1-ad08-93b694f672b4', 'admin', 124);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_settings`
--

CREATE TABLE IF NOT EXISTS `tbl_settings` (
`id` int(11) NOT NULL,
  `title` varchar(25) NOT NULL,
  `value` varchar(45) NOT NULL,
  `type` varchar(8) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='Settings like max jobs displayed, application titles and logo etc etc';

--
-- Dumping data for table `tbl_settings`
--

INSERT INTO `tbl_settings` (`id`, `title`, `value`, `type`) VALUES
(1, 'SITE_EMAIL', 'contact@nurseaid.com.au', ''),
(2, 'COPYRIGHT_INFO', 'Copyright© 2016, NurseAid All rights reserved', ''),
(3, 'NURSEAID_ADDRESS', '11 Stobie Place, Monash, ACT, 2904', ''),
(4, 'APPLICATION_FORM_EMPLOYEE', '4_256.png', 'file'),
(5, 'CONTRACT_EMPLOYEE', '', 'file'),
(6, 'APPLICATION_FORM_EMPLOYER', '', 'file'),
(7, 'CONTRACT_EMPLOYER', '', 'file'),
(8, 'SITE_TITLE', 'NurseAid.com', ''),
(9, 'SMTP_SERVER', 'smtp.wlink.com.np', ''),
(10, 'SMTP_PORT', '25', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_timesheet`
--

CREATE TABLE IF NOT EXISTS `tbl_timesheet` (
  `id` int(11) NOT NULL,
  `accepted_date` datetime DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `duration` float DEFAULT NULL,
  `break` float DEFAULT NULL,
  `ph_150` float DEFAULT NULL,
  `ot_1_5` float DEFAULT NULL,
  `ot_2` float DEFAULT NULL,
  `c_50_per_sat` float DEFAULT NULL,
  `c_75_per_sun` float DEFAULT NULL,
  `tbl_job_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_attachment`
--
ALTER TABLE `tbl_attachment`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_cms`
--
ALTER TABLE `tbl_cms`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_cms_tbl_admin1` (`created_by`);

--
-- Indexes for table `tbl_country`
--
ALTER TABLE `tbl_country`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_employee_tbl_entity_abstract1` (`tbl_entity_abstract_id`), ADD KEY `fk_tbl_employee_tbl_country1` (`tbl_nationality_id`);

--
-- Indexes for table `tbl_employer`
--
ALTER TABLE `tbl_employer`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_employer_tbl_entity_abstract1` (`tbl_entity_abstract_id`);

--
-- Indexes for table `tbl_entity_abstract`
--
ALTER TABLE `tbl_entity_abstract`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_entity_abstract_tbl_country` (`tbl_country_id`);

--
-- Indexes for table `tbl_entity_attachment`
--
ALTER TABLE `tbl_entity_attachment`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_entity_ability_tbl_attachment1` (`tbl_attachment_id`), ADD KEY `fk_tbl_entity_attachment_tbl_entity_abstract1` (`tbl_entity_abstract_id`);

--
-- Indexes for table `tbl_job`
--
ALTER TABLE `tbl_job`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_job_tbl_employer1` (`tbl_employer_id`), ADD KEY `fk_tbl_job_tbl_job_position1` (`position_id`);

--
-- Indexes for table `tbl_job_position`
--
ALTER TABLE `tbl_job_position`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_job_position_tbl_admin1` (`created_by`);

--
-- Indexes for table `tbl_job_status`
--
ALTER TABLE `tbl_job_status`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_job_status_tbl_job` (`tbl_job_id`), ADD KEY `fk_tbl_job_status_tbl_employee1` (`tbl_employee_id`);

--
-- Indexes for table `tbl_message`
--
ALTER TABLE `tbl_message`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_password_reset_request`
--
ALTER TABLE `tbl_password_reset_request`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_settings`
--
ALTER TABLE `tbl_settings`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_timesheet`
--
ALTER TABLE `tbl_timesheet`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tbl_timesheet_tbl_job` (`tbl_job_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=125;
--
-- AUTO_INCREMENT for table `tbl_attachment`
--
ALTER TABLE `tbl_attachment`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_cms`
--
ALTER TABLE `tbl_cms`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `tbl_country`
--
ALTER TABLE `tbl_country`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=241;
--
-- AUTO_INCREMENT for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_employer`
--
ALTER TABLE `tbl_employer`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_entity_abstract`
--
ALTER TABLE `tbl_entity_abstract`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `tbl_entity_attachment`
--
ALTER TABLE `tbl_entity_attachment`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_job`
--
ALTER TABLE `tbl_job`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `tbl_job_position`
--
ALTER TABLE `tbl_job_position`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_job_status`
--
ALTER TABLE `tbl_job_status`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `tbl_message`
--
ALTER TABLE `tbl_message`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_password_reset_request`
--
ALTER TABLE `tbl_password_reset_request`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_settings`
--
ALTER TABLE `tbl_settings`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_cms`
--
ALTER TABLE `tbl_cms`
ADD CONSTRAINT `fk_tbl_cms_tbl_admin1` FOREIGN KEY (`created_by`) REFERENCES `tbl_admin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
ADD CONSTRAINT `fk_tbl_employee_tbl_country1` FOREIGN KEY (`tbl_nationality_id`) REFERENCES `tbl_country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tbl_employee_tbl_entity_abstract1` FOREIGN KEY (`tbl_entity_abstract_id`) REFERENCES `tbl_entity_abstract` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_employer`
--
ALTER TABLE `tbl_employer`
ADD CONSTRAINT `fk_tbl_employer_tbl_entity_abstract1` FOREIGN KEY (`tbl_entity_abstract_id`) REFERENCES `tbl_entity_abstract` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_entity_abstract`
--
ALTER TABLE `tbl_entity_abstract`
ADD CONSTRAINT `fk_tbl_entity_abstract_tbl_country` FOREIGN KEY (`tbl_country_id`) REFERENCES `tbl_country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_entity_attachment`
--
ALTER TABLE `tbl_entity_attachment`
ADD CONSTRAINT `fk_tbl_entity_ability_tbl_attachment1` FOREIGN KEY (`tbl_attachment_id`) REFERENCES `tbl_attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tbl_entity_attachment_tbl_entity_abstract1` FOREIGN KEY (`tbl_entity_abstract_id`) REFERENCES `tbl_entity_abstract` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_job`
--
ALTER TABLE `tbl_job`
ADD CONSTRAINT `fk_tbl_job_tbl_employer1` FOREIGN KEY (`tbl_employer_id`) REFERENCES `tbl_employer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tbl_job_tbl_job_position1` FOREIGN KEY (`position_id`) REFERENCES `tbl_job_position` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_job_position`
--
ALTER TABLE `tbl_job_position`
ADD CONSTRAINT `fk_tbl_job_position_tbl_admin1` FOREIGN KEY (`created_by`) REFERENCES `tbl_admin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_job_status`
--
ALTER TABLE `tbl_job_status`
ADD CONSTRAINT `fk_tbl_job_status_tbl_employee1` FOREIGN KEY (`tbl_employee_id`) REFERENCES `tbl_employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tbl_job_status_tbl_job` FOREIGN KEY (`tbl_job_id`) REFERENCES `tbl_job` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_timesheet`
--
ALTER TABLE `tbl_timesheet`
ADD CONSTRAINT `fk_tbl_timesheet_tbl_job` FOREIGN KEY (`tbl_job_id`) REFERENCES `tbl_job` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
