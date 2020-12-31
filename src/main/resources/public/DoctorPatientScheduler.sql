CREATE TABLE specializations(
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                description varchar(30) UNIQUE
);


CREATE TABLE doctors(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        first_name varchar(30),
                        last_name varchar(30),
                        phone_number varchar (30),
                        email varchar (30),
                        specialization_id INTEGER REFERENCES specializations(id)
);



CREATE TABLE patients(
                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                         first_name varchar(30),
                         last_name varchar(30),
                         phone_number varchar(30),
                         email varchar(30),
                         birth_date date
);

CREATE TABLE appointments
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    doctor_id     int REFERENCES doctors (id),
    patient_id    int REFERENCES patients (id),
    appDate       timestamp,
    status        varchar(30),
    doctor_notes  varchar(30),
    patient_notes varchar(30)
);


CREATE TABLE users
(
    id         INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name varchar(30),
    last_name  varchar(30),
    password   varchar(30)
);


INSERT INTO specializations(description) VALUES('pediatrie');
INSERT INTO specializations(description) VALUES('cardiologie');
INSERT INTO specializations(description) VALUES('medicina interna');
INSERT INTO specializations(description) VALUES('gastro-enterologie');
INSERT INTO specializations(description) VALUES('dermatologie');
INSERT INTO specializations(description) VALUES('ginecologie');
INSERT INTO specializations(description) VALUES('endocrinologie');
INSERT INTO specializations(description) VALUES('reumatologie');
INSERT INTO specializations(description) VALUES('orl');
INSERT INTO specializations(description) VALUES('psihiatrie');
INSERT INTO specializations(description) VALUES('radiologie');
INSERT INTO specializations(description) VALUES('neurologie');
INSERT INTO specializations(description) VALUES('medicina de familie');
INSERT INTO specializations(description) VALUES('balneofizioterapie');
INSERT INTO specializations(description) VALUES('chirurgie');
INSERT INTO specializations(description) VALUES('diabet zaharat si boli metabolice');
INSERT INTO specializations(description) VALUES('geriatrie');
INSERT INTO specializations(description) VALUES('nefrologie');
INSERT INTO specializations(description) VALUES('oncologie');
INSERT INTO specializations(description) VALUES('pneumologie');



INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Mihai', 'Popoescu', 'mihaipopescu@email.com', '0744919900', 1);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Teodora', 'Ionescu', 'teodoraionescu@email.com', '0744919901', 1);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Andrei', 'Vulpe', 'andreivulpe@email.com', '0744919902', 2);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Madalina', 'Coltescu', 'madalinacoltescu@email.com', '0744919903', 2);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Eduard', 'Popovici', 'eduardpopovici@email.com', '0744919904', 3);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Maria', 'Esca', 'mariaesca@email.com', '0744919905', 3);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Ionut', 'Dumbrava', 'ionutdumbrava@email.com', '0744919906', 4);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Gabriela', 'Antonescu', 'gabrielaantonescu@email.com', '0744919907', 4);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Richard', 'Bulancea', 'richardbulancea@email.com', '0744919908', 5);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Claudia', 'Pasare', 'claudiapasare@email.com', '0744919909', 5);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Dan', 'Negru', 'dannegru@email.com', '0744919910', 6);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Georgiana', 'Bilan', 'georgianabilan@email.com', '0744919911', 6);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('David', 'Nechifor', 'davidnechifor@email.com', '0744919912', 7);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Madalina', 'Romila', 'madalinaromila@email.com', '0744919913', 7);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Alexandru', 'Popa', 'alexandrupopa@email.com', '0744919914', 8);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Cristi', 'Bratu', 'cristibratu@email.com', '0744919915', 8);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Benjamin', 'Teodoru', 'benjaminteodoru@email.com', '0744919916', 9);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Iuliana', 'Burlacu', 'iulianaburlacu@email.com', '0744919917', 9);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Madalin', 'Fiore', 'madalinfiore@email.com', '0744919918', 10);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Dumitru', 'Grigoruta', 'dumitrugrigoruta@email.com', '0744919919',10);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Valeria', 'Nestian', 'valerianestian@email.com', '0744919920', 11);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Minodora', 'Bolea', 'minodorabolea@email.com', '0744919921', 11);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Roxana', 'Axinte', 'roxanaaxinte@email.com', '0744919922', 12);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Maria', 'Hedera', 'mariahedera@email.com', '0744919923', 12);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Constantin', 'Stoica', 'constantinstoica@email.com', '0744919924', 13);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Iuliana', 'Vladescu', 'iulianavladescu@email.com', '0744919925', 13);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Andrada', 'Poenaru', 'andradapoenaru@email.com', '0744919926', 14);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Emil', 'Panaitescu', 'emilpanaitecu@email.com', '0744919927', 14);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Dragos', 'Ropota', 'dragosropota@email.com', '0744919928', 15);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Daniel', 'Pantea', 'danielpantea@email.com', '0744919929', 15);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Leontina', 'Calarasu', 'leontinacalarasu@email.com', '0744919930', 16);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Ana Maria', 'Cosmescu', 'anamariacosmescu@email.com', '0744919931', 16);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Florin', 'Badiu', 'florinbadiu@email.com', '0744919932', 17);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Raluca', 'Mazare', 'ralucamazare@email.com', '0744919933', 17);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Ioana', 'Aursulesei', 'ioanaaursulesei@email.com', '0744919934', 18);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Dominic', 'Chetran', 'dominicchetran@email.com', '0744919935', 18);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Mircea', 'Carp', 'mirceacarp@email.com', '0744919936', 19);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Claudiu', 'Iacobuta', 'claudiuiacobuta@email.com', '0744919937', 19);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Eleonora', 'Rovina', 'eleonorarovina@email.com', '0744919938', 20);
INSERT INTO doctors (first_name, last_name, phone_number, email, specialization_id) VALUES('Eugen', 'Ungureanu', 'eugenungureanu@email.com', '0744919939', 20);



INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Claudiu', 'Mircea', '0712129711', 'claudiumircea@email.com', '1948-01-22');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Razvan', 'Dumitrescu', '0712129712', 'razvandumitrescu@email.com', '1945-02-12');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Amalia', 'Ionescu', '0712129713', 'amaliaionescu@email.com','1950-03-18' );
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Andrei', 'Mihaila', '0712129714', 'andreimihaila@email.com','1951-05-14' );
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Adela', 'Ciobanu', '0712129715', 'adelaciobanu@email.com', '1954-10-25');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Mihai', 'Dragan', '0712129716', 'mihaidragan@email.com', '1957-07-02');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Mircea', 'Hutu', '0712129717', 'mirceahutu@email.com', '1957-07-02');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Lacramioara', 'Pascaru', '0712129718', 'lacramioarapascaru@email.com', '1960-03-05');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('David', 'Cristea', '0712129719', 'davidcristea@email.com', '1962-07-19');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Raluca', 'Prelipcean', '0712129710', 'ralucaprelipcean@email.com', '1965-08-07');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Filip', 'Rotaru', '0712129721', 'filiprotaru@email.com', '1967-05-13');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Lidia', 'Margirescu', '0712129722', 'lidiamargirescu@email.com', '1967-01-01');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Casandra', 'Popescu', '0712129723', 'casandrapopescu@email.com', '1968-12-12');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Ludmila', 'Parasca', '0712129724', 'ludmilaparasca@email.com', '1950-01-27');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Anemarie', 'Dulcescu', '0712129725', 'anemariedulcescu@email.com', '1969-07-32');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Costica', 'Rusu', '0712129726', 'costicarusu@email.com', '2015-11-11');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Aliosa', 'Zarnescu', '0712129727', 'aliosazarnescu@email.com', '2016-04-27');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Andra', 'Zarea', '0712129728', 'andrazarea@email.com', '1939-11-10');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Zoita', 'Dulgheru', '0712129729', 'zoitadulgheru@email.com', '1940-10-29');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Toni', 'Stoica', '0712129720', 'tonistoica@email.com', '1937-06-30');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Florentin', 'Vintila', '0712129731', 'florentinvintila@email.com', '1975-03-17');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Stefan', 'Simionescu', '0712129732', 'stefansimionescu@email.com', '1970-02-19');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Paula', 'Ivan', '0712129733', 'paulaivan@email.com', '1984-07-26');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Valentin', 'Domitian', '0712129734', 'valentindomitian@email.com', '1945-02-12');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Andreea', 'Diaconescu', '0712129735', 'andreeadiaconescu@email.com', '1950-03-18');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Vasile', 'Avram', '0712129736', 'vasileavram@email.com', '1980-05-21');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Eugen', 'Lisnic', '0712129737', 'eugenlisnic@email.com', '1982-11-20');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Mariana', 'Sasarman', '0712129738', 'marianasasarman@email.com', '1987-12-06');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Tudor', 'Gheorghe', '0712129739', 'tudorgheorghe@email.com', '1980-04-22');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Benon', 'Valcov', '0712129740', 'benonvalcov@email.com', '1989-05-10');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Gheorghian', 'Voicu', '0712129741', 'gheorghianvoicu@email.com', '1950-07-08');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Mihai', 'Sorocianu', '0712129742', 'mihaisorocianu@email.com', '1967-09-09');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Adriana', 'AAnei', '0712129743', 'adrianaaanei@email.com', '1968-06-29');
INSERT INTO patients (first_name, last_name, phone_number, email, birth_date) VALUES('Ofelia', 'Zaharia', '0712129744', 'ofeliazaharia@email.com', '1970-07-31');




INSERT INTO users (first_name, last_name, password) VALUES('Mihai', 'Popoescu', 'popescum');
INSERT INTO users (first_name, last_name, password) VALUES('Teodora', 'Ionescu', 'ionescut');
INSERT INTO users (first_name, last_name, password) VALUES('Andrei', 'Vulpe', 'andreivulpea');
INSERT INTO users (first_name, last_name, password) VALUES('Madalina', 'Coltescu', 'coltescue');
INSERT INTO users (first_name, last_name, password) VALUES('Eduard', 'Popovici', 'popovicie');
INSERT INTO users (first_name, last_name, password) VALUES('Maria', 'Esca', 'escam');
INSERT INTO users (first_name, last_name, password) VALUES('Ionut', 'Dumbrava', 'dumbravai');
INSERT INTO users (first_name, last_name, password) VALUES('Gabriela', 'Antonescu', 'antonescug');
INSERT INTO users (first_name, last_name, password) VALUES('Richard', 'Bulancea', 'bulancear');
INSERT INTO users (first_name, last_name, password) VALUES('Claudia', 'Pasare', 'pasarec');
INSERT INTO users (first_name, last_name, password) VALUES('Dan', 'Negru', 'negrud');
INSERT INTO users (first_name, last_name, password) VALUES('Georgiana', 'Bilan', 'bilang');
INSERT INTO users (first_name, last_name, password) VALUES('David', 'Nechifor', 'nechiford');
INSERT INTO users (first_name, last_name, password) VALUES('Madalina', 'Romila', 'romilam');
INSERT INTO users (first_name, last_name, password) VALUES('Alexandru', 'Popa', 'popaa');
INSERT INTO users (first_name, last_name, password) VALUES('Cristi', 'Bratu', 'bratuc');
INSERT INTO users (first_name, last_name, password) VALUES('Benjamin', 'Teodoru', 'teodorub');
INSERT INTO users (first_name, last_name, password) VALUES('Iuliana', 'Burlacu', 'burlacui');
INSERT INTO users (first_name, last_name, password) VALUES('Madalin', 'Fiore', 'fiorem');
INSERT INTO users (first_name, last_name, password) VALUES('Dumitru', 'Grigoruta', 'grigorutad');
INSERT INTO users (first_name, last_name, password) VALUES('Valeria', 'Nestian', 'nestianv');
INSERT INTO users (first_name, last_name, password) VALUES('Minodora', 'Bolea', 'boleam');
INSERT INTO users (first_name, last_name, password) VALUES('Roxana', 'Axinte', 'axinter');
INSERT INTO users (first_name, last_name, password) VALUES('Maria', 'Hedera', 'hederam');
INSERT INTO users (first_name, last_name, password) VALUES('Constantin', 'Stoica', 'stoicac');
INSERT INTO users (first_name, last_name, password) VALUES('Iuliana', 'Vladescu', 'vladescui');
INSERT INTO users (first_name, last_name, password) VALUES('Andrada', 'Poenaru', 'poenarua');
INSERT INTO users (first_name, last_name, password) VALUES('Emil', 'Panaitescu', 'panaitecue');
INSERT INTO users (first_name, last_name, password) VALUES('Dragos', 'Ropota', 'ropotad');
INSERT INTO users (first_name, last_name, password) VALUES('Daniel', 'Pantea', 'pantead');
INSERT INTO users (first_name, last_name, password) VALUES('Leontina', 'Calarasu', 'calarasul');
INSERT INTO users (first_name, last_name, password) VALUES('Ana Maria', 'Cosmescu', 'cosmescua');
INSERT INTO users (first_name, last_name, password) VALUES('Florin', 'Badiu', 'badiuf');
INSERT INTO users (first_name, last_name, password) VALUES('Raluca', 'Mazare', 'mazarer');
INSERT INTO users (first_name, last_name, password) VALUES('Ioana', 'Aursulesei', 'aursuleseii');
INSERT INTO users (first_name, last_name, password) VALUES('Dominic', 'Chetran', 'chetranc');
INSERT INTO users (first_name, last_name, password) VALUES('Mircea', 'Carp', 'carpm');
INSERT INTO users (first_name, last_name, password) VALUES('Claudiu', 'Iacobuta', 'iacobutac');
INSERT INTO users (first_name, last_name, password) VALUES('Eleonora', 'Rovina', 'rovinae');
INSERT INTO users (first_name, last_name, password) VALUES('Eugen', 'Ungureanu', 'ungureanue');