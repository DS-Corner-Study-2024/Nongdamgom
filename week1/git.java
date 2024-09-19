/*
<1주차 강의> https://inf.run/kLFpY
쉬운 용어로 배우는 Git & Github 첫걸음 - 협업까지 마스터하기

- pwd(print working directory) 현재 내가 작업하는 폴더를 보여달라는 뜻
- ls(list) 내 폴더 안에 있는 폴더 & 파일 내역을 보여줌
- ls -a(list all) 숨겨진 파일 보기
- cd 폴더명(change directory) (ls 명령어에서 확인된) 폴더로 이동 가능 (cd ../ -> 한 단계 위의 폴더로 이동) 

Git 필수 명령어
- git init(initialize) git을 본격적으로 사용하기 위해 초기 세팅(프로젝트 시작 전 딱 한 번만 입력, 정확한 프로젝트 폴더에서 입력) -> .git 이라는 폴더가 생겨서 코드 변경을 git에서 추적함

- git add 파일명 => 저장하기 전 저장할 파일 지정(지정 안 한 파일은 저장 안 됨)
- git commit -m "메세지 작성" => 실제로 저장하는 명령어
- git status => 저장 여부를 확인(코드 변경o 저장 x인 파일-> 붉은색 표시)
- git add . => 현재 나의 경로 내의 모든 변경된 파일
 

git add .
git commit -m "메모"
하면 전부 저장 됨 (이후 git status 하면 더 이상 저장될 것이 없다고 뜸)

- git log => 저장 내역 확인(저장한 커밋 메시지 확인)
- git diff => 코드 변경 확인
- git reset => 저장된 과거 시점으로 돌아감

수정된 코드 github에 반영

git add .
git commit -m "~"
git push origin 브랜치명(main)

- origin = 내 github 주소

- git branch 브랜치이름 => 브랜치(복사본) 생성(git branch 입력하면 내가 위치하고 있는 브랜치 확인 가능)

- git switch 브랜치이름 or git checkout 브랜치이름 => 브랜치 이동
- git switch -c 브랜치이름 or git checkout -b 브랜치이름 => git 생성과 동시에 이동

브랜치 합치는 명령어
-git switch 최종브랜치이름(main)
- git merge 합칠브랜치이름(내가 작업한 브랜치)

- git push origin (작성한)브랜치명 => github에 업로드
-> github로 이동해서 compare & pull request 클릭
-> base는 main(최종 브랜치), compare는 기능브랜치(직접 작성한 브랜치)
-> 제목에 pull request 메시지 작성
-> merge 버튼-> confirm merge 버튼 누르면 main 브랜치로 merge

git checkout main -> login 브랜치에서 만든 기능 없음 -> github에서 합친 것이 아직 반영 안 됨 ->
git pull origin 브랜치명(main) => github의 변경사항을 내 컴퓨터에 반영

Main 브랜치(배포용)-> 완전하게 개발을 해놔야 함
develop 브랜치(테스트용)
기능 브랜치(기능 개발용)

- git clone 레포주소 => 내 컴퓨터에 코드가 아예 없을 때 코드를 전체 다 가져옴 (git pull은 코드가 있지만 변경 사항을 가져오고 싶을 때 사용)
git switch -c 기능브랜치명

프레임 생성-> 코드 작성-> git add . -> git commit -m "~" -> git push origin 기능브랜치명 -> github에서 풀리퀘

a. 기능 브랜치 생성 및 코드 작성
b. Git add, commit, push
c. Pull request 생성 및 코드 리뷰
d. 내 로컬에서 충돌 해결 및 테스트 => 수정했다면 add & commit & push
e. merge 버튼 클릭

- git reset --hard 커밋아이디(git log로 커밋아이디 확인) => 되돌아가고 싶은 커밋아이디를 사용하여 돌아감
hard: 코드&커밋 모두 날아감
soft: 코드는 그대로, 커밋만 날아감
mixed: soft랑 같음, but 변경된 코드가 git add 전 상태로 남아 있음
이 명령어는 사용하지 않는 편이 좋음(팀원들의 커밋을 삭제할 수도)

- git stash => 코드 임시 저장(커밋하기에는 애매하고 코드를 임시로 저장해놓고 싶을 때)
- git stash apply <stash@뒤숫자> => 임시 저장한 코드 다시 사용
- -m: 메시지를 남길 수 있음 git stash -m "~"
- -u: git add 된 적 없는 파일들도 포함
git stash -u -m "메시지"

- git revert 커밋아이디 => 과거로 되돌아감
git revert => 이미 git push를 한 경우, git reset 시 팀원과 커밋 기록이 꼬일 수 있을 때
 */