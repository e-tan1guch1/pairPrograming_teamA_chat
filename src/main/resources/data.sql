-- ユーザーテーブルデータ
INSERT INTO users(name, email,password) VALUES('荒川講師', 'arakawa@mail', 'aaa');
INSERT INTO users(name, email,password) VALUES('白戸講師', 'shiroto@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('伊山', 'iyama@mail', 'iii');
INSERT INTO users(name, email,password) VALUES('谷口', 'taniguchi@mail', 'ttt');
INSERT INTO users(name, email,password) VALUES('犬', 'inu@mail', 'iii');
INSERT INTO users(name, email,password) VALUES('猫', 'neko@mail', 'nnn');
INSERT INTO users(name, email,password) VALUES('魔神', 'mazion@mail', 'mmm');
INSERT INTO users(name, email,password) VALUES('山田', 'yamada@mail', 'yyy');
INSERT INTO users(name, email,password) VALUES('朝青龍', 'asa@mail', 'aaa');
INSERT INTO users(name, email,password) VALUES('ダンボ', 'danbo@mail', 'ddd');
INSERT INTO users(name, email,password) VALUES('柴犬', 'shiba@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('餃子', 'gyoza@mail', 'ggg');
INSERT INTO users(name, email,password) VALUES('肉団子', 'niku@mail', 'nnn');
INSERT INTO users(name, email,password) VALUES('久保川奏希', 'kubokawa@mail', 'kkk');
INSERT INTO users(name, email,password) VALUES('吉田鷹', 'yoshida@mail', 'yyy');
INSERT INTO users(name, email,password) VALUES('寺迫駿', 'terasako@mail', 'ttt');
INSERT INTO users(name, email,password) VALUES('ゴリラ', 'gorilla@mail', 'ggg');
INSERT INTO users(name, email,password) VALUES('織田信長', 'oda@mail', 'ooo');
INSERT INTO users(name, email,password) VALUES('冷蔵庫', 'reizouko@mail', 'rrr');
INSERT INTO users(name, email,password) VALUES('鈴木一郎', 'suzuki@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('田中次郎', 'tanaka@mail', 'ttt');
INSERT INTO users(name, email,password) VALUES('のぞみ', 'nozomi@mail', 'nnn');
INSERT INTO users(name, email,password) VALUES('海', 'umi@mail', 'uuu');
INSERT INTO users(name, email,password) VALUES('鯖', 'saba@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('鮪', 'maguro@mail', 'mmm');
INSERT INTO users(name, email,password) VALUES('鰹', 'katsuo@mail', 'kkk');
INSERT INTO users(name, email,password) VALUES('鯛', 'tai@mail', 'tai');
INSERT INTO users(name, email,password) VALUES('秋刀魚', 'sanma@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('蛤', 'hamaguri@mail', 'hhh');
INSERT INTO users(name, email,password) VALUES('雲丹', 'uni@mail', 'uuu');
INSERT INTO users(name, email,password) VALUES('鰆', 'sawara@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('鮭', 'sake@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('鯵', 'aji@mail', 'aaa');
INSERT INTO users(name, email,password) VALUES('鱗', 'uroko@mail', 'uuu');
INSERT INTO users(name, email,password) VALUES('鮎', 'ayu@mail', 'aaa');
INSERT INTO users(name, email,password) VALUES('鮃', 'hirame@mail', 'hhh');
INSERT INTO users(name, email,password) VALUES('蛸', 'tako@mail', 'ttt');
INSERT INTO users(name, email,password) VALUES('海老', 'ebi@mail', 'eee');
INSERT INTO users(name, email,password) VALUES('烏賊', 'ika@mail', 'iii');

--user1とuser2
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, 'こんにちは', 2, '2023-07-04 09:29:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '荒川です', 2, '2023-07-04 09:30:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(2, 'お疲れ様です', 1, '2023-07-04 09:31:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(2, 'こんにちは', 1, '2023-07-04 09:32:30.053193');

--user1とuser3
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '今、何していますか？', 3, '2023-07-05 09:29:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(3, 'お昼を食べています。', 1, '2023-07-05 09:30:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '何を食べていますか？', 3, '2023-07-05 09:31:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(3, 'ハンバーグを食べています。', 1, '2023-07-05 09:32:30.053193');

--user1とuser4
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '今日も暑いですね。', 4, '2023-07-04 09:29:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(4, '暑いですね。', 1, '2023-07-04 09:30:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '30°超えるらしいですよ。', 4, '2023-07-04 09:31:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(4, '30°ですか！！', 1, '2023-07-04 09:32:30.053193');

--user1とuser5
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '遊びにいきませんか？。', 5, '2023-07-04 09:29:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(5, 'いいですね！', 1, '2023-07-04 09:30:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(5, 'いきましょう！', 1, '2023-07-04 09:30:50.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '船釣りはいかがですか？', 5, '2023-07-04 09:31:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(5, 'ごめんなさい', 1, '2023-07-04 09:32:30.053193');
INSERT INTO chats(user_id, text, address_id, date) VALUES(5, '船酔いしてしまいます。', 1, '2023-07-04 09:32:50.053193');


INSERT INTO friends(user_id, user2_id) VALUES(1, 2);
INSERT INTO friends(user_id, user2_id) VALUES(2, 1);
INSERT INTO friends(user_id, user2_id) VALUES(1, 3);
INSERT INTO friends(user_id, user2_id) VALUES(3, 1);
INSERT INTO friends(user_id, user2_id) VALUES(1, 4);
INSERT INTO friends(user_id, user2_id) VALUES(4, 1);
INSERT INTO friends(user_id, user2_id) VALUES(1, 5);
INSERT INTO friends(user_id, user2_id) VALUES(5, 1);


INSERT INTO requests(user2_id, user_id) VALUES(1, 6);

INSERT INTO icons(icon_url) VALUES('/images/icons/businessman.png');
INSERT INTO icons(icon_url) VALUES('/images/icons/businesswoman.png');
INSERT INTO icons(icon_url) VALUES('/images/icons/car.png');
INSERT INTO icons(icon_url) VALUES('/images/icons/fish.png');
INSERT INTO icons(icon_url) VALUES('/images/icons/flower.png');
