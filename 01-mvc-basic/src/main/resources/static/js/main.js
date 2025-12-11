// Spring MVC Basic - Main JavaScript

// 페이지 로드 완료 시 실행
document.addEventListener('DOMContentLoaded', function() {
  console.log('Spring MVC Basic Application Loaded');

  // Virtual Thread 정보 출력 (있는 경우)
  logThreadInfo();

  // 테이블 행 hover 효과
  enhanceTableRows();

  // 부드러운 스크롤
  smoothScroll();
});

/**
 * Virtual Thread 정보 로깅
 */
function logThreadInfo() {
  const isVirtual = document.querySelector('[data-virtual-thread]');
  if (isVirtual) {
    const value = isVirtual.dataset.virtualThread;
    console.log(`Virtual Thread: ${value}`);
  }
}

/**
 * 테이블 행 개선
 */
function enhanceTableRows() {
  const tables = document.querySelectorAll('.member-table');
  tables.forEach(table => {
    const rows = table.querySelectorAll('tbody tr');
    rows.forEach((row, index) => {
      row.addEventListener('click', function() {
        console.log(`Row ${index + 1} clicked`);
      });
    });
  });
}

/**
 * 부드러운 스크롤
 */
function smoothScroll() {
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
      e.preventDefault();
      const target = document.querySelector(this.getAttribute('href'));
      if (target) {
        target.scrollIntoView({
          behavior: 'smooth',
          block: 'start'
        });
      }
    });
  });
}

/**
 * API 호출 예제 (fetch)
 */
async function fetchMembers() {
  try {
    const response = await fetch('/api/members');
    const data = await response.json();
    console.log('Members:', data);
    return data;
  } catch (error) {
    console.error('Error fetching members:', error);
  }
}

/**
 * 날짜 포맷팅 유틸리티
 */
function formatDate(date) {
  return new Date(date).toLocaleString('ko-KR', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit'
  });
}