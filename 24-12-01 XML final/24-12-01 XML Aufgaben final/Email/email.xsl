<?xml version='1.0' encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="email">
		<html>
			<head><title>E-Mail</title></head>
			<body>
				<table border="1">
					<xsl:apply-templates/>
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="empfaenger">
		<tr><th>Empfänger</th>
			<td><xsl:apply-templates/></td>
		</tr>
	</xsl:template>

	<xsl:template match="kopieAn">
		<tr><th>Kopie An</th>
			<td><xsl:apply-templates/></td>
		</tr>
	</xsl:template>

	<xsl:template match="absender">
		<tr><th>Absender</th>
			<td><xsl:apply-templates/></td>
		</tr>
	</xsl:template>

	<xsl:template match="thema">
		<tr><th>Betreff</th>
			<td><xsl:apply-templates/></td>
		</tr>
	</xsl:template>

	<xsl:template match="nachricht">
		<tr><th>Nachricht</th>
			<td><pre><xsl:apply-templates/></pre></td>
		</tr>
	</xsl:template>



</xsl:stylesheet>
