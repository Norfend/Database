INSERT INTO "Accounts" (login, password)
VALUES
('dcrinage0', 'aF4@g+o5'),
('gmawne1', 'fW89ZcMNT#.QBl4K'),
('dklugel2', 'aD9!,qiAB!l%w'),
('ebrason4', 'kT7n#c1>%v6DlFi'),
('gsign5', 'dE3,mi$t'),
('emonroe6', 'sV1TtO~/TR%a'),
('jeyree7', 'jL3EOooU'),
('mfawdry9', 'lZ2<g`tG<?'),
('gcogdella', 'vN9jI+C13e'),
('psustinb', 'bV8CL\DK$gjsVhQ'),
('arehmec', 'eC2!bp#@rDQpKOp7');

INSERT INTO "Clients"
("firstName","secondName","phoneNumber","Accounts_login","loyaltyPoints")
VALUES
('Aubrie', 'McParlin', '6605255666', 'dcrinage0', '5210'),
('Kiley', 'Probbin', '3004870240', 'gmawne1', '1172'),
('Alexine', 'Shorter', '2348526948', 'dklugel2', '3649'),
('Pris', 'Pattinson', '5628588535', 'ebrason4', '4523'),
('Elke', 'Papworth', '6844486242', 'gsign5', '8596'),
('Roxi', 'Lindfors', '8455969851', 'emonroe6', '4533'),
('Antonella', 'Kasbye', '7436985640', 'jeyree7', '1897'),
('Tilda', 'Waylett', '2576290159', 'mfawdry9', '359'),
('Kris', 'Grundey', '8362631662', 'gcogdella', '7692'),
('Karylin', 'Latch', '2447996446', 'psustinb', '9430'),
('Ursula', 'Seamark', '8826459802', 'arehmec', '6424');

INSERT INTO "Employees"
("firstName","secondName","phoneNumber","Accounts_login","salary","address")
VALUES
('Bari', 'Simkins', '3311264680', 'dgwillyam1b', '68742', ('Baoxu',
'Drewry')),
('Leora', 'Dorrance', '8087197376', 'zjeavons1d', '51067', ('Guanbuqiao',
'Rowland')),
('Redd', 'Ossenna', '9003593876', 'lmamwell1e', '54911', ('Maracay',
'Brickson Park')),
('Tally', 'Ziebart', '5603317058', 'molechnowicz1f', '89889', ('Sala',
'Jay')),
('Dorita', 'Caddan', '9699092396', 'ebiddiss1g', '71097', ('Khromtau',
'Linden')),
('Benny', 'McAdam', '3036877256', 'gsperrett1h', '33639', ('José de Freitas',
'Del Sol')),
('Stephanie', 'Islep', '1836478184', 'mphilpots1i', '39970', ('Nanuque',
'Dakota')),
('Nathanil', 'Ivantsov', '2799210890', 'bantoniewicz1k', '59222', ('Sampao',
'Clove')),
('Kain', 'Kingscote', '9936695507', 'llemmanbie1l', '59354', ('Gourma
Rharous', 'Warbler')),
('Angy', 'Tolson', '7273142370', 'rgiabucci1m', '30809', ('Trzebnica',
'Washington')),
('Berenice', 'Harbottle', '5514517908', 'ccovelle1n', '63235', ('Muleng',
'Cody'));

INSERT INTO "Cars" ("VIN","manufacturer","model","year","owner")
VALUES
('JTEBU4BF9AK464993', 'Mitsubishi', 'Endeavor', '2009', '15'),
('3G5DA03E23S553243', 'Lotus', 'Esprit', '2001', '20'),
('WBA3N7C52FK552737', 'Honda', 'S2000', '2007', '11'),
('SCFFDABE5CG528434', 'Nissan', 'Sentra', '2000', '33'),
('1G6DE8EG7A0669247', 'Hyundai', 'Tiburon', '2007', '22'),
('WDDEJ7GB8AA853752', 'Ford', 'Aspire', '1994', '9'),
('WBA3A5G51CN077070', 'BMW', 'Alpina B7', '2007', '39'),
('JTDJTUD37ED845354', 'Mazda', 'B-Series', '2001', '3'),
('3D7JV1EPXAG111398', 'Volvo', 'S40', '2004', '20'),
('3GYEK62NX6G153107', 'Chevrolet', 'Monte Carlo', '1999', '19');

INSERT INTO "Orders" ("date","payer","subject")
VALUES
(('1', '11', '2003'), '28', 'JTDJTUD37ED845354'),
(('18', '6', '2001'), '12', '3D7JV1EPXAG111398'),
(('25', '12', '2011'), '13', 'JTEBU4BF9AK464993'),
(('7', '1', '2016'), '19', 'JTEBU4BF9AK464993'),
(('18', '4', '2000'), '32', '3D7JV1EPXAG111398'),
(('20', '7', '2010'), '2', 'WDDEJ7GB8AA853752'),
(('29', '2', '2016'), '5', '1G6DE8EG7A0669247'),
(('20', '10', '2010'), '11', 'SCFFDABE5CG528434'),
(('2', '11', '2002'), '3', '3GYEK62NX6G153107'),
(('1', '2', '2021'), '38', 'JTDJTUD37ED845354'),
(('23', '1', '2009'), '24', 'WBA3N7C52FK552737');

INSERT INTO "Invoice" ("orderNumber","totalCost")
VALUES
('62', '$2397.23'),
('49', '$1941.68'),
('5', '$6561.99'),
('31', '$9691.51'),
('7', '$4016.19'),
('53', '$6577.86'),
('78', '$8215.79'),
('59', '$1777.74'),
('70', '$3184.86'),
('94', '$6206.62'),
('49', '$2196.87');

INSERT INTO supervisor ("employee", "supervisor")
VALUES
('1', NULL),
('2', '1'),
('3', '2'),
('4', '2'),
('5', '1'),
('6', '5'),
('7', '5'),
('8', '1'),
('9', '8'),
('10', '8'),
('11', '3');

INSERT INTO "orderOperations" ("orderNumber", "operation")
VALUES
('30', 'cultivate 24/365 applications'),
('13', 'brand seamless ROI'),
('80', 'synthesize visionary technologies'),
('23', 'scale viral eyeballs'),
('64', 'envisioneer synergistic action-items'),
('41', 'generate compelling vortals'),
('46', 'visualize viral action-items'),
('27', 'embrace e-business relationships'),
('37', 'expedite global partnerships'),
('28', 'synthesize open-source vortals'),
('78', 'monetize real-time action-items');

INSERT INTO "worker" ("orderNumber", "employee_ID")
VALUES
('69', '34'),
('62', '19'),
('36', '22'),
('34', '32'),
('25', '24'),
('73', '22'),
('31', '19'),
('66', '29'),
('46', '27'),
('55', '14'),
('56', '27');

INSERT INTO "items" ("item")
VALUES
('Chick Peas - Canned'),
('Energy Drink'),
('Sole - Fillet'),
('Waffle Stix'),
('Heavy Duty Dust Pan'),
('Cheese - Sheep Milk'),
('Wine - Toasted Head'),
('V8 Splash Strawberry Kiwi'),
('Halibut - Whole, Fresh'),
('Longos - Assorted Sandwich'),
('Cake Circle, Paprus');

INSERT INTO "orderItems" ("item")
VALUES
('Chick Peas - Canned'),
('Energy Drink'),
('Sole - Fillet'),
('Waffle Stix'),
('Heavy Duty Dust Pan'),
('Cheese - Sheep Milk'),
('Wine - Toasted Head'),
('V8 Splash Strawberry Kiwi'),
('Halibut - Whole, Fresh'),
('Longos - Assorted Sandwich'),
('Cake Circle, Paprus');

INSERT INTO "Order contain orderItems" ("orderNumber", "orderItem_ID")
VALUES
('33', '9'),
('17', '91'),
('83', '1'),
('97', '27'),
('96', '48'),
('36', '19'),
('30', '58'),
('14', '32'),
('5', '7'),
('46', '71'),
('26', '7');

INSERT INTO "Invoice_has_items" ("Invoice_orderNumber", "Invoice_number",
"items_item_ID")
VALUES
('62', '1', '65'),
('49', '2', '63'),
('5', '3', '82'),
('31', '4', '8'),
('7', '5', '28'),
('53', '6', '96'),
('78', '7', '54'),
('59', '8', '57'),
('70', '9', '93'),
('94', '10', '85'),
('49', '11', '3');