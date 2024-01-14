# manytoone onetomany/// 쿼리 하나만을 사용하여 Member만 select하기!<br/><br/>

Member(Entity) 안에는 member의 정보, team, role 있다.<br/>
이 상태에서 JPA의 findall을 하게되면 쿼리가 여려개 발생하다. <br/>
단순 Member의 정보만을 원할 때는 쓸모없는 쿼리가 발생하기 때문에 좋지않음.<br/><br/>

방법1. <br/>
Member의 Dto를 따로 만들고, @ManyToOne의 fetch전략을 LAZY로 설정. <br/>
ModelMapper이용하여 Member(Entity)와 MemberDto를 맵핑해서 select해온다.<br/>
(이때 Team과 Role은 가져오지 않음) <br/><br/>

방법2.

