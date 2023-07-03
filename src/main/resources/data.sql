-- ユーザーテーブルデータ
INSERT INTO users(name, email,password) VALUES('荒川講師', 'arakawa@mail', 'aaa');
INSERT INTO users(name, email,password) VALUES('白戸講師', 'shiroto@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('伊山', 'iyama@mail', 'iii');
INSERT INTO users(name, email,password) VALUES('谷口', 'taniguchi@mail', 'ttt');
INSERT INTO users(name, email,password) VALUES('大魔神', 'mazion@mail', 'mmm');
INSERT INTO users(name, email,password) VALUES('犬', 'inu@mail', 'iii');
INSERT INTO users(name, email,password) VALUES('スコティッシュフォールド', 'nekosama@mail', 'nnn');

INSERT INTO friends(user_id, user2_id) VALUES(1, 2);
INSERT INTO friends(user_id, user2_id) VALUES(2, 1);
INSERT INTO friends(user_id, user2_id) VALUES(1, 3);
INSERT INTO friends(user_id, user2_id) VALUES(3, 1);
INSERT INTO friends(user_id, user2_id) VALUES(1, 4);
INSERT INTO friends(user_id, user2_id) VALUES(4, 1);
INSERT INTO friends(user_id, user2_id) VALUES(1, 5);
INSERT INTO friends(user_id, user2_id) VALUES(5, 1);


INSERT INTO requests(user2_id, user_id) VALUES(1, 6);