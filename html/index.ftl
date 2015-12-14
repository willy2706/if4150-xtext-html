<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Resume</title>
<link type="text/css" rel="stylesheet" href="css/blue.css" />
<link type="text/css" rel="stylesheet" href="css/print.css" media="print"/>
<!--[if IE 7]>
<link href="css/ie7.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!--[if IE 6]>
<link href="css/ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.tipsy.js"></script>
<script type="text/javascript" src="js/cufon.yui.js"></script>
<script type="text/javascript" src="js/scrollTo.js"></script>
<script type="text/javascript" src="js/myriad.js"></script>
<script type="text/javascript" src="js/jquery.colorbox.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript">
		Cufon.replace('h1,h2');
</script>
</head>
<body>
<!-- Begin Wrapper -->
<div id="wrapper">
  <div class="wrapper-top"></div>
  <div class="wrapper-mid">
    <!-- Begin Paper -->
    <div id="paper">
      <div class="paper-top"></div>
      <div id="paper-mid">
        <div class="entry">
          <#if biodata.photo ??>
          <!-- Begin Image -->
          <img class="portrait" src="${biodata.photo}" alt="${biodata.name}" />
          <!-- End Image -->
          </#if>
          <!-- Begin Personal Information -->
          <div class="self">
            <h1 class="name">${biodata.name} <br /></h1>
            <ul>
              <li class="mail">${biodata.email}</li>
              <#if biodata.phone ??><li class="tel">${biodata.phone}</li></#if>
              <#if biodata.socialMedias??>
                  <#list biodata.socialMedias as socialmedia>
                      <li class="web">${socialmedia}</li>
                  </#list>
              </#if>
            </ul>
          </div>
          <!-- End Personal Information -->
          <#--<!-- Begin Social &ndash;&gt;-->
          <#--<div class="social">-->
            <#--<ul>-->
              <#--<li><a class='north' href="#" title="Download .pdf"><img src="images/icn-save.jpg" alt="Download the pdf version" /></a></li>-->
              <#--<li><a class='north' href="javascript:window.print()" title="Print"><img src="images/icn-print.jpg" alt="" /></a></li>-->
              <#--<li><a class='north' id="contact" href="contact/index.html" title="Contact Me"><img src="images/icn-contact.jpg" alt="" /></a></li>-->
              <#--<li><a class='north social_facebook ' href="#" title="Facebook"><img src="images/icn-facebook.jpg" alt="" /> </a></li>-->
              <#--<li><a class='north' href="#" title="Follow me on Twitter"><img src="images/icn-twitter.jpg" alt="" /></a></li> -->
              <#--<li><a class='north' href="#" title="Instagram"><img src="images/icn-facebook.jpg" alt="" /></a></li>-->
              <#--<li><a class='north' href="#" title="LinkedIn"><img src="images/icn-facebook.jpg" alt="" /></a></li>-->
              <#--<li><a class='north' href="#" title="Path"><img src="images/icn-facebook.jpg" alt="" /></a></li>-->
              <#--<li><a class='north' href="#" title="Line"><img src="images/icn-facebook.jpg" alt="" /></a></li>-->

            <#--</ul>-->
          <#--</div>-->
          <#--<!-- End Social &ndash;&gt;-->
        </div>
        <!-- Begin 1st Row -->
        <#if biodata.summary??>
        <div class="entry">
          <h2>OBJECTIVE</h2>
          <p>${biodata.summary}</p>
        </div>
        </#if>
        <!-- End 1st Row -->
        <!-- Begin 2nd Row -->
        <#if academics??>
        <div class="entry">
          <h2>EDUCATION</h2>
          <#list academics as academic>
            <div class="content">
              <h3>${academic.from} <#if academic.until??> - ${academic.until} <#else> - present </#if></h3>
              <p>${academic.name}<#if academic.city ??>, ${academic.city} </#if>  <br />
                <#if academic.major??>
                  <em>${academic.level} in ${academic.major}
                  <#if academic.gpa ??>
                    GPA: ${academic.gpa}
                  </#if>
                  </em>
                </#if>
              </p>
            </div>
          </#list>
        </div>
        </#if>
        <!-- End 2nd Row -->
        <!-- Begin 3rd Row -->
        <#if workExperiences??>
        <div class="entry">
          <h2>WORK EXPERIENCE</h2>
          <#list workExperiences as work>
          <div class="content">
            <h3>${work.from} <#if work.until??> - ${work.until} <#else> - present  </#if></h3>
            <p>${work.name}<#if work.city??>, ${work.city} </#if> <br />
              <em>${work.position}</em>
            </p>
            <#if work.infos ??>
            <ul class="info">
              <#list work.infos as info>
              <li>${info}</li>
              </#list>
            </ul>
            </#if>
          </div>
          </#list>
        </div>
        </#if>
        <!-- End 3rd Row -->
        <!-- Begin 4rd Row -->
        <#if organizationExperiences??>
        <div class="entry">
          <h2>ORGANIZATION EXPERIENCE</h2>
          <#list organizationExperiences as organization>
          <div class="content">
            <h3>${organization.from}<#if organization.until ??> - ${organization.until} <#else> - present  </#if></h3>
            <p>${organization.name}<#if organization.city??>, ${organization.city} </#if> <br />
              <em>${organization.position}</em>
            </p>
            <#if organization.infos ??>
            <ul class="info">
              <#list organization.infos as info>
              <li>${info}</li>
              </#list>
            </ul>
            </#if>
          </div>
          </#list>
        </div>
        </#if>
        <!-- End 4rd Row -->
        <!-- Begin 5rd Row -->
        <#if committees??>
        <div class="entry">
          <h2>COMMITTEE</h2>
          <#list committees as committee>
          <div class="content">
            <h3>${committee.from} <#if committee.until ??> - ${committee.until} <#else> - present  </#if></h3>
            <p>${committee.name}, ${committee.organization} <br />
              <em>${committee.position}</em>
            </p>
            <#if committee.infos ??>
            <ul class="info">
              <#list committee.infos as info>
              <li>${info}</li>
              </#list>
            </ul>
            </#if>
          </div>
          </#list>
        </div>
        </#if>
        <!-- End 5rd Row -->
        <!-- Begin 6th Row -->
        <#if expertises??>
        <div class="entry">
          <#if expertises??>
          <h2>SKILLS</h2>
          <div class="content">
            <h3>Expertise</h3>
            <ul class="skills">
              <#list expertises as expertise>
              <li>${expertise.name}</li>
              </#list>
            </ul>
          </div>
          </#if>

          <#if languages??>
          <div class="content">
            <h3>Languages</h3>
            <ul class="skills">
              <#list languages as language>
                <p>${language.name}, ${language.level} <br />
                  <#if language.tests??>
                  <ul class="info">
                    <#list language.tests as test>
                    <em>${test.testName} : ${test.score}</em>
                    </#list>
                  </ul>
                  </#if>
                </p>
              </#list>
            </ul>
          </div>
          </#if>
        </div>
        </#if>
        <!-- End 6th Row -->
         <#--<!-- Begin 5th Row &ndash;&gt;-->
        <#--<div class="entry">-->
        <#--<h2>WORKS</h2>-->
        	<#--<ul class="works">-->
        		<#--<li><a href="images/1.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        		<#--<li><a href="images/2.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        		<#--<li><a href="images/3.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        		<#--<li><a href="images/1.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        		<#--<li><a href="images/2.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        		<#--<li><a href="images/3.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        		<#--<li><a href="images/1.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        		<#--<li><a href="images/1.jpg" rel="gallery" title="Lorem ipsum dolor sit amet."><img src="images/image.jpg" alt="" /></a></li>-->
        	<#--</ul>-->
        <#--</div>-->
        <#--<!-- Begin 5th Row &ndash;&gt;-->
      </div>
      <div class="clear"></div>
      <div class="paper-bottom"></div>
    </div>
    <!-- End Paper -->
  </div>
  <div class="wrapper-bottom"></div>
</div>
<div id="message"><a href="#top" id="top-link">Go to Top</a></div>
<!-- End Wrapper -->
</body>
</html>
