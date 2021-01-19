Semi_CarrotCountry
==================

* ## 핵심내용
    사용자의 동네를 기반한 중고거래 사이트에 공동구매기능을 더해 지역내 동네 주민들과의 커뮤니케이션을 활성화 시키며, 원하는 물건을 쉽고 저렴하게 구매할 수 있는 사이트를 구현.

* ## 기획배경
    기존의 중고거래 사이트의 취약점을 보완하고자 사용자의 지역거래를 통한 중고거래 신뢰도를 강화하고 1인 가구의 증가로 인한 합리적 소비로 떠오르고 있는 공동구매를 통하여 사용자들이 보다 저렴하고 쉽게 물품을 구매할 수 있는 서비스를 제공하고자 한다.

* ## 목적
    1. 우리 동네만의 커뮤니티 활성화
    1. 안전하고 신속한 직거래
    1. 동네 주민들과의 공동구매
    
* ## 개발기간
    2020.09.18 ~ 2020.11.12
* ## 사용기술
    ![캡처](https://user-images.githubusercontent.com/54658104/102349993-89649e00-3fe7-11eb-87ee-b62edcb203f4.PNG)

* ## 데이터베이스
    ![Carrot_Contry ERD](https://user-images.githubusercontent.com/54658104/102349493-bf555280-3fe6-11eb-9f19-3fec314bbc82.png)

* ## 기능상세
* ### 사용자
    * **회원서비스**   
        회원가입   
        로그인   
        로그아웃   
        ID 찾기   
    * **마이페이지**   
        프로필정보 조회/수정   
        회원탈퇴   
        내가 쓴 게시물 조회   
        내가 찜한 게시물 조회(관심 상품)   
        거래이력관리   
    * **중고거래 게시글**   
        중고물품 등록/수정/삭제   
        전체물품조회   
        중고물품 상세조회 게시글신고/댓글달기/댓글신고   
        중고물품검색   
        게시글 찜하기   
    * **공동구매 게시글**   
        공동구매 등록/수정/삭제   
        공동구매 조회/상세조회   
        공동구매 구매/결제   
    * **고객센터**
        공지사항   
        FAQ서비스   
        문의서비스(문의작성/조회하기)   
* ### 관리자
    * **회원관리**   
        회원전체조회   
        회원 블랙리스트 처리   
        블랙리스트 회원 조회/해제   
        회원검색   
    * **게시글관리**   
        게시글전체 조회/상세조회   
        게시글 블라인드 처리   
        게시글검색   
    * **고객센터관리**   
        공지사항관리 조회/등록/수정/삭제   
        FAQ관리   
        1대1 문의내역관리   
        신고내역   

* ## 기능구현
     <img src="https://user-images.githubusercontent.com/54658104/102353009-e6fae980-3feb-11eb-8ac6-2c5bf6448520.JPG" alt="슬라이드23">
     <img src="https://user-images.githubusercontent.com/54658104/102353014-e82c1680-3feb-11eb-8c24-f5ebb0b1dfe3.JPG" alt="슬라이드24">
     <img src="https://user-images.githubusercontent.com/54658104/102353016-e8c4ad00-3feb-11eb-9199-bf99a66bb8ef.JPG" alt="슬라이드25">
     <img src="https://user-images.githubusercontent.com/54658104/102353019-e8c4ad00-3feb-11eb-89d0-4957f8cec600.JPG" alt="슬라이드26">
     <img src="https://user-images.githubusercontent.com/54658104/102353021-e95d4380-3feb-11eb-873a-41afcad6223c.JPG" alt="슬라이드27">
     <img src="https://user-images.githubusercontent.com/54658104/102353022-e9f5da00-3feb-11eb-8d18-dcf1ab9c9bca.JPG" alt="슬라이드28">
     <img src="https://user-images.githubusercontent.com/54658104/102353024-e9f5da00-3feb-11eb-9af5-b6a7576ba45a.JPG" alt="슬라이드30">
     <img src="https://user-images.githubusercontent.com/54658104/102353025-ea8e7080-3feb-11eb-8d44-573bd5fa1654.JPG" alt="슬라이드31">
     <img src="https://user-images.githubusercontent.com/54658104/102353026-ea8e7080-3feb-11eb-96d6-8caadaac8f66.JPG" alt="슬라이드32">
     <img src="https://user-images.githubusercontent.com/54658104/102353027-eb270700-3feb-11eb-8899-27439ef1dfb5.JPG" alt="슬라이드33">
     <img src="https://user-images.githubusercontent.com/54658104/102353030-eb270700-3feb-11eb-813f-b84c50950de2.JPG" alt="슬라이드34">
     <img src="https://user-images.githubusercontent.com/54658104/102353031-ebbf9d80-3feb-11eb-8cfc-287abd7ec5d4.JPG" alt="슬라이드35">
     <img src="https://user-images.githubusercontent.com/54658104/102353032-ebbf9d80-3feb-11eb-92b6-0c863103cf01.JPG" alt="슬라이드36">
     <img src="https://user-images.githubusercontent.com/54658104/102353034-ec583400-3feb-11eb-9c29-e7013279fcfb.JPG" alt="슬라이드37">
     <img src="https://user-images.githubusercontent.com/54658104/102353035-ecf0ca80-3feb-11eb-91a9-2d8cb4a38672.JPG" alt="슬라이드38">
     <img src="https://user-images.githubusercontent.com/54658104/102353037-ecf0ca80-3feb-11eb-85c0-e86e8785a2a5.JPG" alt="슬라이드40">
     <img src="https://user-images.githubusercontent.com/54658104/102353038-ed896100-3feb-11eb-8d7f-6140c4ed99ad.JPG" alt="슬라이드41">
     <img src="https://user-images.githubusercontent.com/54658104/102353040-ed896100-3feb-11eb-8d3a-96e05e4d1975.JPG" alt="슬라이드42">
     <img src="https://user-images.githubusercontent.com/54658104/102353042-ee21f780-3feb-11eb-9a73-f9c29e8e6804.JPG" alt="슬라이드43">
     <img src="https://user-images.githubusercontent.com/54658104/102353044-eeba8e00-3feb-11eb-83e7-27d8611614b5.JPG" alt="슬라이드44">
     <img src="https://user-images.githubusercontent.com/54658104/102353045-eeba8e00-3feb-11eb-8f83-761b5e385150.JPG" alt="슬라이드45">
     <img src="https://user-images.githubusercontent.com/54658104/102353047-ef532480-3feb-11eb-90b2-95adcd20ecc1.JPG" alt="슬라이드46">
     <img src="https://user-images.githubusercontent.com/54658104/102353048-ef532480-3feb-11eb-90d9-84b158d82295.JPG" alt="슬라이드47">
     <img src="https://user-images.githubusercontent.com/54658104/102353049-efebbb00-3feb-11eb-8417-33605f88fe21.JPG" alt="슬라이드48">
     <img src="https://user-images.githubusercontent.com/54658104/102353050-f0845180-3feb-11eb-982a-777682d38a7e.JPG" alt="슬라이드49">
     <img src="https://user-images.githubusercontent.com/54658104/102353051-f0845180-3feb-11eb-8985-1db4019b7187.JPG" alt="슬라이드50">
     <img src="https://user-images.githubusercontent.com/54658104/102353054-f11ce800-3feb-11eb-8c70-1e636e2392e9.JPG" alt="슬라이드52">
     <img src="https://user-images.githubusercontent.com/54658104/102353055-f11ce800-3feb-11eb-8cb8-95258e5b9f45.JPG" alt="슬라이드53">
     <img src="https://user-images.githubusercontent.com/54658104/102353057-f1b57e80-3feb-11eb-885d-4cb6fda2da1c.JPG" alt="슬라이드54">
     <img src="https://user-images.githubusercontent.com/54658104/102353058-f24e1500-3feb-11eb-8a8b-ecd0b332eb84.JPG" alt="슬라이드55">
     <img src="https://user-images.githubusercontent.com/54658104/102353063-f24e1500-3feb-11eb-8ba2-4584b19261b3.JPG" alt="슬라이드56">
     <img src="https://user-images.githubusercontent.com/54658104/102353067-f2e6ab80-3feb-11eb-8093-89abf498357d.JPG" alt="슬라이드57">
     <img src="https://user-images.githubusercontent.com/54658104/102353068-f2e6ab80-3feb-11eb-8297-0844d3a74279.JPG" alt="슬라이드58">
     <img src="https://user-images.githubusercontent.com/54658104/102353071-f37f4200-3feb-11eb-800c-d29a272d318d.JPG" alt="슬라이드59">
     <img src="https://user-images.githubusercontent.com/54658104/102353072-f37f4200-3feb-11eb-8d50-f918803537ae.JPG" alt="슬라이드60">
     <img src="https://user-images.githubusercontent.com/54658104/102353073-f417d880-3feb-11eb-9f23-b0ab1f57e78e.JPG" alt="슬라이드61">
     <img src="https://user-images.githubusercontent.com/54658104/102353074-f417d880-3feb-11eb-85bd-8b1701374586.JPG" alt="슬라이드62">
     <img src="https://user-images.githubusercontent.com/54658104/102353076-f4b06f00-3feb-11eb-8f6e-356dfb84dd42.JPG" alt="슬라이드63">
     <img src="https://user-images.githubusercontent.com/54658104/102353077-f4b06f00-3feb-11eb-8bc1-30cd76132438.JPG" alt="슬라이드64">
     <img src="https://user-images.githubusercontent.com/54658104/102353079-f5490580-3feb-11eb-8d7d-0406b015033f.JPG" alt="슬라이드65">
     <img src="https://user-images.githubusercontent.com/54658104/102353080-f5490580-3feb-11eb-9e16-89d153aa6e81.JPG" alt="슬라이드66">
     <img src="https://user-images.githubusercontent.com/54658104/102353081-f5e19c00-3feb-11eb-8f59-2baf82c08c92.JPG" alt="슬라이드67">
     <img src="https://user-images.githubusercontent.com/54658104/102353083-f5e19c00-3feb-11eb-97a0-21c2c53c02fd.JPG" alt="슬라이드68">
     <img src="https://user-images.githubusercontent.com/54658104/102353086-f67a3280-3feb-11eb-80f1-644b57300baa.JPG" alt="슬라이드70">
     <img src="https://user-images.githubusercontent.com/54658104/102353088-f712c900-3feb-11eb-9c3b-173a17010bbe.JPG" alt="슬라이드71">
     <img src="https://user-images.githubusercontent.com/54658104/102353091-f712c900-3feb-11eb-852d-3353f3651b21.JPG" alt="슬라이드72">
     <img src="https://user-images.githubusercontent.com/54658104/102353094-f7ab5f80-3feb-11eb-9eea-f5746e23a0c4.JPG" alt="슬라이드73">
     <img src="https://user-images.githubusercontent.com/54658104/102353095-f7ab5f80-3feb-11eb-9eeb-fc62b5f38b78.JPG" alt="슬라이드74">
     <img src="https://user-images.githubusercontent.com/54658104/102353097-f843f600-3feb-11eb-9289-4b33e5dfb3b4.JPG" alt="슬라이드75">
     <img src="https://user-images.githubusercontent.com/54658104/102353099-f843f600-3feb-11eb-84c8-25478a74f867.JPG" alt="슬라이드76">
     <img src="https://user-images.githubusercontent.com/54658104/102353100-f8dc8c80-3feb-11eb-8b35-55cd6ef4efed.JPG" alt="슬라이드77">
     <img src="https://user-images.githubusercontent.com/54658104/102353102-f9752300-3feb-11eb-9b44-00f5125a393e.JPG" alt="슬라이드78">
     <img src="https://user-images.githubusercontent.com/54658104/102353104-f9752300-3feb-11eb-853b-38b800b3129a.JPG" alt="슬라이드79">
     <img src="https://user-images.githubusercontent.com/54658104/102353105-fa0db980-3feb-11eb-9464-44109cb29d9b.JPG" alt="슬라이드80">
     <img src="https://user-images.githubusercontent.com/54658104/102353109-fa0db980-3feb-11eb-9b64-fc133dae6534.JPG" alt="슬라이드82">
     <img src="https://user-images.githubusercontent.com/54658104/102353111-faa65000-3feb-11eb-9694-e5ac745080df.JPG" alt="슬라이드83">
     <img src="https://user-images.githubusercontent.com/54658104/102353112-faa65000-3feb-11eb-82d0-abbdf35cd59e.JPG" alt="슬라이드84">
     <img src="https://user-images.githubusercontent.com/54658104/102353114-fb3ee680-3feb-11eb-83f0-9e47bb2da492.JPG" alt="슬라이드85">
     <img src="https://user-images.githubusercontent.com/54658104/102353116-fb3ee680-3feb-11eb-83e2-d8448e615e75.JPG" alt="슬라이드86">
     <img src="https://user-images.githubusercontent.com/54658104/102353118-fbd77d00-3feb-11eb-9ddc-944fddcde29a.JPG" alt="슬라이드87">
     <img src="https://user-images.githubusercontent.com/54658104/102353119-fc701380-3feb-11eb-9891-a7c9b7209ea0.JPG" alt="슬라이드88">
     <img src="https://user-images.githubusercontent.com/54658104/102353121-fd08aa00-3feb-11eb-82e0-6d4d49b6bf17.JPG" alt="슬라이드89">
     <img src="https://user-images.githubusercontent.com/54658104/102353123-fd08aa00-3feb-11eb-84b0-f96a904a81c2.jpg" alt="슬라이드90">

