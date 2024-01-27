# ///manytoone onetomany/// 
# 쿼리 하나 -> 
# 1. Member만 select <br/>
# 2. Member, Team, Role 3가지 select<br/><br/>


개요 <br/>
Member(Entity) 안에는 member의 정보, team, role 있다.<br/>
이 상태에서 JPA의 findall을 하게되면 쿼리가 여려개 발생하다. <br/>
단순 Member의 정보만을 원할 때는 쓸모없는 쿼리가 발생하기 때문에 좋지않음.<br/><br/>
![getMemberList1](https://github.com/jeongseyoung/manytoone/assets/19800292/7f9692ab-47b9-4659-bf98-d732c8797b3f)

방법1. <br/>
Member의 Dto를 따로 만들고, @ManyToOne의 fetch전략을 LAZY로 설정. <br/>
ModelMapper이용하여 Member(Entity)를 MemberDto와 맵핑해서 select해온다.<br/>
(이때 Team과 Role은 가져오지 않음) <br/>
![getMemberList2](https://github.com/jeongseyoung/manytoone/assets/19800292/1e2de622-3742-4a39-8896-6888aa597657)

Modelmapper란?<br/><br/>
방법2. -> @NamedEntityGraph <br/>
@NamedEntityGraph를 Member(Entity)에 달아준다. <br/>
Repository에 List<Member> findAll을 만듦. -> 쿼리 하나로 Member, Team, Role을 전부 가져옴. <br/>
![getMemberList3](https://github.com/jeongseyoung/manytoone/assets/19800292/b4b67e51-acf3-42f1-a8f7-e0589c7cdac8)


@NamedEntityGraph란?<br/><br/><br/>


-참고자료<br/>
https://www.youtube.com/watch?v=MpXdx8-qWzo&t=241s
