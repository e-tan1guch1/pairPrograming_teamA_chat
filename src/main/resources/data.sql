-- ユーザーテーブルデータ
INSERT INTO users(name, email,password) VALUES('荒川講師', 'arakawa@mail', 'aaa');
INSERT INTO users(name, email,password) VALUES('白戸講師', 'shiroto@mail', 'sss');
INSERT INTO users(icon_id,name, email,password) VALUES('10','伊山', 'iyama@mail', 'iii');
INSERT INTO users(icon_id,name, email,password) VALUES('35','谷口', 'taniguchi@mail', 'ttt');
INSERT INTO users(icon_id,name, email,password) VALUES('37','犬', 'inu@mail', 'iii');
INSERT INTO users(icon_id,name, email,password) VALUES('40','猫', 'neko@mail', 'nnn');
INSERT INTO users(icon_id,name, email,password) VALUES('9','魔女', 'majyo@mail', 'mmm');
INSERT INTO users(name, email,password) VALUES('山田', 'yamada@mail', 'yyy');
INSERT INTO users(name, email,password) VALUES('朝青龍', 'asa@mail', 'aaa');
INSERT INTO users(name, email,password) VALUES('ダンボ', 'danbo@mail', 'ddd');
INSERT INTO users(name, email,password) VALUES('柴犬', 'shiba@mail', 'sss');
INSERT INTO users(name, email,password) VALUES('餃子', 'gyoza@mail', 'ggg');
INSERT INTO users(icon_id,name, email,password) VALUES('31','肉団子', 'niku@mail', 'nnn');
INSERT INTO users(name, email,password) VALUES('ゴリラ', 'gorilla@mail', 'ggg');
INSERT INTO users(icon_id,name, email,password) VALUES('11','織田信長', 'oda@mail', 'ooo');
INSERT INTO users(icon_id,name, email,password) VALUES('23','冷蔵庫', 'reizouko@mail', 'rrr');
INSERT INTO users(icon_id,name, email,password) VALUES('6','鈴木一郎', 'suzuki@mail', 'sss');
INSERT INTO users(icon_id,name, email,password) VALUES('12','田中次郎', 'tanaka@mail', 'ttt');
INSERT INTO users(name, email,password) VALUES('のぞみ', 'nozomi@mail', 'nnn');
INSERT INTO users(icon_id,name, email,password) VALUES('15','海', 'umi@mail', 'uuu');
INSERT INTO users(icon_id,name, email,password) VALUES('29','鯖', 'saba@mail', 'sss');
INSERT INTO users(icon_id,name, email,password) VALUES('18','鮪', 'maguro@mail', 'mmm');
INSERT INTO users(icon_id,name, email,password) VALUES('19','鰹', 'katsuo@mail', 'kkk');
INSERT INTO users(icon_id,name, email,password) VALUES('22','鯛', 'tai@mail', 'tai');
INSERT INTO users(icon_id,name, email,password) VALUES('22','秋刀魚', 'sanma@mail', 'sss');
INSERT INTO users(icon_id,name, email,password) VALUES('25','蛤', 'hamaguri@mail', 'hhh');
INSERT INTO users(icon_id,name, email,password) VALUES('22','雲丹', 'uni@mail', 'uuu');
INSERT INTO users(icon_id,name, email,password) VALUES('19','鰆', 'sawara@mail', 'sss');
INSERT INTO users(icon_id,name, email,password) VALUES('30','鮭', 'sake@mail', 'sss');
INSERT INTO users(icon_id,name, email,password) VALUES('29','鯵', 'aji@mail', 'aaa');
INSERT INTO users(icon_id,name, email,password) VALUES('30','鱗', 'uroko@mail', 'uuu');
INSERT INTO users(icon_id,name, email,password) VALUES('29','鮎', 'ayu@mail', 'aaa');
INSERT INTO users(icon_id,name, email,password) VALUES('30','鮃', 'hirame@mail', 'hhh');
INSERT INTO users(icon_id,name, email,password) VALUES('32','蛸', 'tako@mail', 'ttt');
INSERT INTO users(icon_id,name, email,password) VALUES('13','海老', 'ebi@mail', 'eee');
INSERT INTO users(icon_id,name, email,password) VALUES('14','烏賊', 'ika@mail', 'iii');

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


INSERT INTO requests(reciever_id, sender_id) VALUES(1, 6);

INSERT INTO icons(icon_url) VALUES('/images/icons/businessman.png');--1
INSERT INTO icons(icon_url) VALUES('/images/icons/businesswoman.png');--2
INSERT INTO icons(icon_url) VALUES('/images/icons/car.png');--3
INSERT INTO icons(icon_url) VALUES('/images/icons/fish.png');--4
INSERT INTO icons(icon_url) VALUES('/images/icons/flower.png');--5

INSERT INTO icons(icon_url) VALUES('/images/icons/athlete.png');--6
INSERT INTO icons(icon_url) VALUES('/images/icons/bacon.png');--7
INSERT INTO icons(icon_url) VALUES('/images/icons/boy.png');--8
INSERT INTO icons(icon_url) VALUES('/images/icons/broommagic.png');--9
INSERT INTO icons(icon_url) VALUES('/images/icons/callcenter.png');--10
INSERT INTO icons(icon_url) VALUES('/images/icons/cyber.png');--11
INSERT INTO icons(icon_url) VALUES('/images/icons/daruma.png');--12
INSERT INTO icons(icon_url) VALUES('/images/icons/ebi.png');--13
INSERT INTO icons(icon_url) VALUES('/images/icons/ikasugata.png');--14
INSERT INTO icons(icon_url) VALUES('/images/icons/ikura.png');--15
INSERT INTO icons(icon_url) VALUES('/images/icons/killerwhale.png');--16
INSERT INTO icons(icon_url) VALUES('/images/icons/littlepig.png');--17
INSERT INTO icons(icon_url) VALUES('/images/icons/maguro1.png');--18
INSERT INTO icons(icon_url) VALUES('/images/icons/maguro3.png');--19
INSERT INTO icons(icon_url) VALUES('/images/icons/man.png');--20
INSERT INTO icons(icon_url) VALUES('/images/icons/obake1.png');--21
INSERT INTO icons(icon_url) VALUES('/images/icons/obake2.png');--22
INSERT INTO icons(icon_url) VALUES('/images/icons/ojizousan.png');--23
INSERT INTO icons(icon_url) VALUES('/images/icons/police.png');--24
INSERT INTO icons(icon_url) VALUES('/images/icons/reachmichael.png');--25
INSERT INTO icons(icon_url) VALUES('/images/icons/robot.png');--26
INSERT INTO icons(icon_url) VALUES('/images/icons/royalpen.png');--27
INSERT INTO icons(icon_url) VALUES('/images/icons/scarftonakai.png');--28
INSERT INTO icons(icon_url) VALUES('/images/icons/simplefish1.png');--29
INSERT INTO icons(icon_url) VALUES('/images/icons/simplefish2.png');--30
INSERT INTO icons(icon_url) VALUES('/images/icons/steak.png');--31
INSERT INTO icons(icon_url) VALUES('/images/icons/tako.png');--32
INSERT INTO icons(icon_url) VALUES('/images/icons/tetsukaosamu.png');--33
INSERT INTO icons(icon_url) VALUES('/images/icons/tonakai.png');--34
INSERT INTO icons(icon_url) VALUES('/images/icons/woman.png');--35
INSERT INTO icons(icon_url) VALUES('/images/icons/gaikotsu.png');--36
INSERT INTO icons(icon_url) VALUES('/images/icons/inu.png');--37
INSERT INTO icons(icon_url) VALUES('/images/icons/kajino.png');--38
INSERT INTO icons(icon_url) VALUES('/images/icons/kani.png');--39
INSERT INTO icons(icon_url) VALUES('/images/icons/manekineko.png');--40
INSERT INTO icons(icon_url) VALUES('/images/icons/niwatori.png');--41
INSERT INTO icons(icon_url) VALUES('/images/icons/okame.png');--42
INSERT INTO icons(icon_url) VALUES('/images/icons/shinkansen.png');--43
INSERT INTO icons(icon_url) VALUES('/images/icons/shishimai.png');--44
INSERT INTO icons(icon_url) VALUES('/images/icons/woman2.png');--45
INSERT INTO icons(icon_url) VALUES('/images/icons/zou.png');--46
