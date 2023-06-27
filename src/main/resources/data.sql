-- ユーザーテーブルデータ
INSERT INTO users(name, email,password) VALUES('チャット君', 'chat@a.com', 'himitu');
INSERT INTO users(name, email,password) VALUES('荒川講師', 'arawaka@mail', 'himitu');


-- チャットテーブルデータ
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, 'ここにメッセージが表示されます', 1, null);
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '左のリストから送信先を選択して、 チャットを始めよう！', 1, null);