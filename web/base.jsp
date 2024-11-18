<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>介绍Project Sekai</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-size: cover;
            background-attachment: fixed;
            color: #ffffff;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1200px;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.8);
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            border-radius: 10px;
        }
        h1 {
            color: #ffcc00;
            font-size: 36px;
            margin-bottom: 20px;
        }
        h2 {
            color: #ffcc00;
            font-size: 28px;
            margin-top: 40px;
        }
        p {
            font-size: 18px;
            color: #cccccc;
            line-height: 1.6;
        }
        ul {
            text-align: left;
            display: inline-block;
            margin-top: 20px;
            margin-bottom: 20px;
            padding-left: 20px;
        }
        ul li {
            font-size: 18px;
            margin-bottom: 10px;
        }
        .images {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin-top: 20px;
        }
        .images img {
            margin: 10px;
            max-width: 70%;
            height: auto;
            transition: transform 0.3s ease;
        }
        .images img:hover {
            transform: scale(1.05);
        }
        .footer {
            text-align: center;
            padding: 20px;
            background-color: #333333;
            color: #ffffff;
            margin-top: 40px;
            border-radius: 0 0 10px 10px;
        }
        .footer a {
            color: #ffcc00;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Project Sekai</h1>
    <p>
        劇情方面，玩家將穿梭於「現實世界」與「世界」兩個場所，劇情的對話場景採用Live2D技術，玩家也能在推進故事的過程解鎖新服裝、歌曲等多項要素。除此之外，3DMV中登場的角色皆可自由更換，在「現實世界」購入的服裝也會於3DMV中呈現，玩家可以用喜歡的角色或造型來鑑賞生動美麗的3DMV。<br>
        歌曲方面，本作收錄了大量的高人氣VOCALOID樂曲，並與高人氣VOCALOID P們合作推出新的原創歌曲。<br>
        操作方面，指令將由上而下出現並配合節奏與不同指令來打出COMBO，而遊玩過程中背景也將播放由SEGA Games所製作的3DMV供玩家欣賞，但考慮到歌曲本身給人的印象，有些歌曲將採用2DMV的形式來表現。<br>
        遊戲有3種不同的音符，包括單點(TAP)、滑鍵(FLICK)、長按(HOLD)。值得一提的是，遊戲內的某些歌曲還會分成「原曲ver.」（虛擬歌手ver.），與由虛擬歌手與遊戲原創角色共同演唱的「世界ver.」供玩家選擇，而歌曲難度也從最簡單的Easy到最上級的Master共分為五個階段，讓玩家能自由選擇適合自己的難度遊玩。<br>
        遊戲譜面設計風格與同為SEGA製作的街機音遊CHUNITHM極為近似，比如交叉的長按滑條、不同寬度的音符等；而判定條件有同有異，比如可以多指全壓糊奇形長按，卻不能滑動糊密集單點。<br>
        遊戲內設有「虛擬演唱會」(Virtual Live)模式，可以讓各位玩家實時在遊戲裡體驗演唱會。虛擬演唱會過程中，可以通過點擊螢幕來揮動應援棒，滑動或傾斜設備來自由移動視角，並且可以和其他玩家一起用各種各樣的方式進行應援（更換應援棒顏色或者使用禮物、動作、表情）。被很多外國粉絲當飯拍使用。<br>
    </p>
    <h2>乐队介绍</h2>
    <table>
        <div class="band">
            <tr>
                <td>
                    <img src="image/Leoneed.png" width="300" align="left">
                </td>
                <td>
                    <p>Leo/need是一支以四名少女组成的乐队，她们通过音乐表达自己的情感和故事。乐队成员包括星乃一歌、天馬咲希、望月穗波和日野森志步。</p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="images">
                        <img src="image/Leo.jpg">
                    </div>
                </td>
            </tr>
            <tr>

                <td>
                    <img src="image/MoreMoreJump.png" width="300" align="left">
                </td>
                <td>
                    <p>MORE MORE JUMP! 是一支由前偶像成员组成的乐队，她们决心通过音乐再次追逐梦想。乐队成员包括花里みのり、桐谷遥、桃井爱莉和日野森志步。</p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="images">
                        <img src="image/MMJ.jpg">
                    </div>
                </td>
            </tr>
            <tr>

                <td>
                    <img src="image/VividBadSQUAD.png" width="300" align="left">
                </td>
                <td>
                    <p>Vivid BAD SQUAD是一支街头音乐风格的乐队，他们通过音乐表达对世界的不满和对自由的追求。乐队成员包括小豆沢こはね、白石杏、東雲彰人和青柳冬弥。</p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="images">
                        <img src="image/VBS.jpg">
                    </div>
                </td>
            </tr>
            <tr>

                <td>
                    <img src="image/WonderlandShowtime.png" width="300" align="left">
                </td>
                <td>
                    <p>Wonderlands×Showtime是一支充满幻想色彩的乐队，他们通过音乐和表演带给观众欢乐和惊喜。乐队成员包括天馬司、鳳えむ、草薙寧々和神代類。</p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="images">
                        <img src="image/WS.jpg">
                    </div>
                </td>
            </tr>
            <tr>

                <td>
                    <img src="image/25jiNightcord.png" width="300" align="left">
                </td>
                <td>
                    <p>25ji,Nightcord 是一支神秘的深夜乐队，他们的音乐充满了情感和深度。乐队成员包括宵崎奏、朝比奈まふゆ、东雲絵名和晓山瑞希。</p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="images">
                        <img src="image/25JI.jpg">
                    </div>
                </td>
            </tr>
        </div>
    </table>
<div class="footer">
    <p>更多信息，请访问 <a href="https://pjsekai.sega.jp/">Project Sekai 官方网站</a>。</p>
</div>
</body>
</html>